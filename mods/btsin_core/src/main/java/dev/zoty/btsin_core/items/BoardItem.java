package dev.zoty.btsin_core.items;

import java.util.Optional;

public class BoardItem extends BTSINItemVariant {
    public BoardItem() {
        super("board");
        // Vanilla
        this.addVariant(0, 0xc29d62, "oak");
        this.addVariant(1, 0x856338, "spruce");
        this.addVariant(2, 0xd7c185, "birch");
        this.addVariant(3, 0xb88764, "jungle");
        this.addVariant(4, 0xba6337, "acacia");
        this.addVariant(5, 0x4f3218, "dark_oak");

        // Biomes O' Plenty
        this.addVariant(6, 0xc29d62, "sacred_oak"); // needs custom texture overlay
        this.addVariant(7, 0x8b2e2c, "cherry");
        this.addVariant(8, 0x766588, "umbran");
        this.addVariant(9, 0xa79c83, "fir");
        this.addVariant(10, 0x4a9473, "ethereal");
        this.addVariant(11, 0x537ac5, "magic");
        this.addVariant(12, 0xf1e8db, "mangrove");
        this.addVariant(13, 0xd19445, "palm");
        this.addVariant(14, 0xa5553a, "redwood");
        this.addVariant(15, 0xa2b084, "willow");
        this.addVariant(16, 0xa27e64, "pine");
        this.addVariant(17, 0x3b3031, "hellbark");
        this.addVariant(18, 0xcfb5ac, "jacaranda");
        this.addVariant(19, 0xc38180, "mahogany");
        this.addVariant(20, 0x2d2c2a, "ebony");
        this.addVariant(21, 0xcbb37a, "eucalyptus"); // needs custom texture overlay
    }

    @Override
    public Optional<String> getOredict() {
        return Optional.of("oreBoard");
    }
}
