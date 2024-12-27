package dev.zoty.btsin_core.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BTSINItemVariant extends BTSINItem {
    private final Map<Integer, VariantData> variants;

    BTSINItemVariant(String slug) {
        super(slug);
        setHasSubtypes(true);
        this.variants = new HashMap<>();
    }

    public void addVariant(int id, int color, String translationKey) {
        this.variants.put(id, new VariantData(color, translationKey));
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        int metadata = stack.getMetadata();
        VariantData subItemData = variants.getOrDefault(metadata, VariantData.DEFAULT);
        return super.getTranslationKey() + '.' + subItemData.translationKey;
    }

    public int getColor(int id) {
        return variants.getOrDefault(id, VariantData.DEFAULT).color;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            variants.keySet().forEach(id -> items.add(new ItemStack(this, 1, id)));
        }
    }

    @Override
    public void registerModel() {
        for (Map.Entry<Integer, VariantData> entry : variants.entrySet()) {
            Integer meta = entry.getKey();
            VariantData variantData = entry.getValue();
            ModelLoader.setCustomModelResourceLocation(this, meta, new ModelResourceLocation(getRegistryName(), "inventory"));
        }
    }

    @Override
    public void registerColor(ItemColors colorsRef) {
        colorsRef.registerItemColorHandler(
                new BTSINItemColorHandler(this),
                this
        );
    }

    public ArrayList<ItemStack> getVariants() {
        ArrayList<ItemStack> variants = new ArrayList<ItemStack>();
        for (Map.Entry<Integer, VariantData> entry : this.variants.entrySet()) {
            variants.add(new ItemStack(this, 1, entry.getKey()));
        }
        return variants;
    }

    private static class VariantData {
        public static final VariantData DEFAULT = new VariantData(0xFFFFFF, "unkonwn");
        public final int color;
        public final String translationKey;

        public VariantData(int color, String translationKey) {
            this.color = color;
            this.translationKey = translationKey;
        }
    }
}
