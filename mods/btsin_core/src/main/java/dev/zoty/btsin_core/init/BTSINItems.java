package dev.zoty.btsin_core.init;

import dev.zoty.btsin_core.items.BTSINItem;
import dev.zoty.btsin_core.items.BTSINItemColorHandler;
import dev.zoty.btsin_core.items.BTSINItemVariant;
import dev.zoty.btsin_core.items.BoardItem;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class BTSINItems {
    public static final List<BTSINItem> itemList = new ArrayList<>();

    public static BTSINItemVariant BOARD = new BoardItem();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        itemReadyForRegister(BOARD);

        for (BTSINItem item : itemList) {
            event.getRegistry().register(item);
            item.postRegistry();
        };
    }

    public static BTSINItem itemReadyForRegister(BTSINItem item) {
        itemList.add(item);

        return item;
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (BTSINItem item : itemList) {
            item.registerModel();
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onColorHandler(ColorHandlerEvent.Item event) {
        for (BTSINItem item: itemList) {
            item.registerColor(event.getItemColors());
        }
    }
}
