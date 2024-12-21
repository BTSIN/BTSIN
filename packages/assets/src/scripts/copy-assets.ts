import fs from 'fs';
import path from 'path';
import { promisify } from 'util';

const copyFile = promisify(fs.copyFile);
const mkdir = promisify(fs.mkdir);
const readdir = promisify(fs.readdir);
const stat = promisify(fs.stat);

interface PathMapping {
  source: string;
  destination: string;
}

const modpackDir = '../../../../apps/modpack';

const mappings: PathMapping[] = [
  {
    source: path.resolve(__dirname, '../textures/planets/shaded/'),
    destination: path.resolve(__dirname, `${modpackDir}/config/defaultworldgenerator-port/`),
  },
  {
    source: path.resolve(__dirname, '../textures/planets/space_icons/'),
    destination: path.resolve(__dirname, `${modpackDir}/groovy/assets/advancedrocketry/textures/planets/`),
  }
]

async function copyDirectory(source: string, destination: string): Promise<void> {
  const entries = await readdir(source);

  for (const entry of entries) {
    const sourcePath = path.join(source, entry);
    const destPath = path.join(destination, entry);

    const stats = await stat(sourcePath);

    if (stats.isDirectory()) {
      if (!fs.existsSync(destPath)) {
        await mkdir(destPath, { recursive: true });
      }
      await copyDirectory(sourcePath, destPath);
    } else {
      await copyFile(sourcePath, destPath);
      console.log(`Copied ${sourcePath} to ${destPath}`);
    }
  }
}

async function copyAssets(): Promise<void> {
  for (const { source, destination } of mappings) {
    try {
      console.log(`Copying from ${source} to ${destination}`);
      if (!fs.existsSync(destination)) {
        await mkdir(destination, { recursive: true });
      }
      await copyDirectory(source, destination);
      console.log(`Finished copying from ${source} to ${destination}`);
    } catch (error) {
      console.error(`Failed to copy from ${source} to ${destination}:`, error);
    }
  }
}

copyAssets().catch((err) => {
  console.error('Error during asset copy:', err);
});
