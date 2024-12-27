package dev.zoty.btsin_core.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CommonProxy {
    @SideOnly(Side.CLIENT)
    public void registerItemRenderer(Item item, int meta, String id) { }

    @SideOnly(Side.CLIENT)
    public void registerItemVariantModel(Item item, String name, int metadata) { }
}
