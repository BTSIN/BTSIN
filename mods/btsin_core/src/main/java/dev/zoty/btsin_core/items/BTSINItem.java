package dev.zoty.btsin_core.items;

import dev.zoty.btsin_core.Tags;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Optional;

public class BTSINItem extends Item {
    private String oreDict;

    public BTSINItem(String slug) {
        this(slug, "");
    }

    public BTSINItem(String slug, String oreDict) {
        super();
        setTranslationKey(Tags.MOD_ID + "." + slug);
        setRegistryName(slug);
        this.oreDict = oreDict;
    }

    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public void registerColor(ItemColors colorsRef) { }

    public Optional<String> getOredict() {
        return Optional.empty();
    }

    public void postRegistry() {
        if (this.getOredict().isPresent()) {
            OreDictionary.registerOre(this.getOredict().get(), this);
        }
    }
}
