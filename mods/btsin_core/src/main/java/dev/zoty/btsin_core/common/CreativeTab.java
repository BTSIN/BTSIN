package dev.zoty.btsin_core.common;

import dev.zoty.btsin_core.init.BTSINItems;
import dev.zoty.btsin_core.items.BTSINItem;
import dev.zoty.btsin_core.items.BTSINItemVariant;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.ArrayList;

public class CreativeTab extends CreativeTabs {
    public CreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BTSINItems.BOARD, 1, 0);
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> list) {
        for (BTSINItem item : BTSINItems.itemList)  {
            if (item instanceof BTSINItemVariant) {
                this.add(list, ((BTSINItemVariant) item).getVariants());
            } else {
                this.add(list, item);
            }
        }
    }
    public void add(NonNullList<ItemStack> list, ArrayList<ItemStack> stackList) {
        for (ItemStack stack : stackList) {
            this.add(list, stack);
        }
    }

    public void add(NonNullList<ItemStack> list, Item item) {
        ItemStack newStack = new ItemStack(item, 1);
        this.add(list, newStack);
    }

    public void add(NonNullList<ItemStack> list, Item item, int meta) {
        ItemStack newStack = new ItemStack(item, 1, meta);
        this.add(list, newStack);
    }

    public void add(NonNullList<ItemStack> list, ItemStack stack) {
        list.add(stack);
    }
}
