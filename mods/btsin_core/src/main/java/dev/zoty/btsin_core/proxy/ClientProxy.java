package dev.zoty.btsin_core.proxy;

import dev.zoty.btsin_core.init.BTSINItems;
import dev.zoty.btsin_core.items.BTSINItemColorHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    @Override
    public void registerItemVariantModel(Item item, String name, int metadata) {
        ModelLoader.registerItemVariants(item, new ResourceLocation(name));
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(name, "inventory"));
    }
}
