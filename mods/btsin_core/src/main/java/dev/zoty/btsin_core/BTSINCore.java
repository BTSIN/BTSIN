package dev.zoty.btsin_core;

import dev.zoty.btsin_core.Tags;
import dev.zoty.btsin_core.common.CreativeTab;
import dev.zoty.btsin_core.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class BTSINCore {
    public static final String CLIENT_PROXY_CLASS = "dev.zoty.btsin_core.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "dev.zoty.btsin_core.proxy.CommonProxy";

    @SidedProxy(clientSide = BTSINCore.CLIENT_PROXY_CLASS, serverSide = BTSINCore.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    public static CreativeTabs BTSINCORETAB = new CreativeTab("btsin_core");
}
