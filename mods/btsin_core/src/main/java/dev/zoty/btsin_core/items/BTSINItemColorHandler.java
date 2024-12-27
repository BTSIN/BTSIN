package dev.zoty.btsin_core.items;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class BTSINItemColorHandler implements IItemColor {
    private final BTSINItemVariant item;

    public BTSINItemColorHandler(BTSINItemVariant item) {
        this.item = item;
    }

    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        if (tintIndex == 0) {
            int metadata = stack.getMetadata();
            return item.getColor(metadata);
        }
        return 0xFFFFFF;
    }
}
