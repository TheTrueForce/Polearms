package trueForce.polearms;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import trueForce.polearms.proxy.CommonProxy;
import static trueForce.polearms.item.ModItems.*;

@Mod.EventBusSubscriber
@Mod(modid = Polearms.MODID, name = Polearms.MODNAME, version = Polearms.VERSION, acceptedMinecraftVersions = Polearms.MC_VERSION)
public class Polearms {

    public static final String MODID = "polearms"; // this does not change
    public static final String DOMAIN = MODID;
    public static final String MODNAME = "Polearms";
    public static final String VERSION = "2.1";
    public static final String MC_VERSION = "1.10.2";
    public static final String NETWORK_CHANNEL_NAME = "MODID";

    @Instance(MODID)
    public static Polearms instance = new Polearms();

    @SidedProxy(clientSide = "trueForce.polearms.proxy.ClientProxy", serverSide = "trueForce.polearms.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger = LogManager.getLogger(MODID);

    public static SimpleNetworkWrapper network;

    ////////////////////////////////////////////////////////////////////////
    // Event Handlers
    ////////////////////////////////////////////////////////////////////////
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        proxy.registerItems(event);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
