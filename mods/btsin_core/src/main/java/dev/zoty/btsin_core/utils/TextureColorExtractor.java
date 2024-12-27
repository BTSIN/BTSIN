package dev.zoty.btsin_core.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TextureColorExtractor {
    public static int getAverageColor(ResourceLocation texture) {
        try {
            BufferedImage image = ImageIO.read(Minecraft.getMinecraft().getResourceManager().getResource(texture).getInputStream());

            int width = image.getWidth();
            int height = image.getHeight();

            long red = 0, green = 0, blue = 0;
            int count = 0;

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int pixel = image.getRGB(x, y);

                    int r = (pixel >> 16) & 0xFF;
                    int g = (pixel >> 8) & 0xFF;
                    int b = pixel & 0xFF;

                    red += r;
                    green += g;
                    blue += b;
                }
            }

            int avgRed = (int) (red / count);
            int avgGreen = (int) (green / count);
            int avgBlue = (int) (blue / count);

            return (avgRed << 16) | (avgGreen << 8) | avgBlue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0xFFFFFF;
    }
}
