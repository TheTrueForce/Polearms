package trueForce.polearms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import trueForce.polearms.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Polearms.MODID, name = Polearms.MODNAME, version = Polearms.VERSION, acceptedMinecraftVersions = Polearms.MC_VERSION)
public class Polearms {
	
	public static final String MODID = "polearms";
	public static final String DOMAIN = "polearms";
	public static final String MODNAME = "Polearms";
	public static final String VERSION = "2.0";
	public static final String MC_VERSION = "1.10.2";
	public static final String NETWORK_CHANNEL_NAME = "polearms";

	@Instance
	public static Polearms instance = new Polearms();
	
	@SidedProxy(clientSide = "trueForce.polearms.proxy.ClientProxy", serverSide = "trueForce.polearms.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static Logger logger = LogManager.getLogger(MODID);
	
	public static SimpleNetworkWrapper network;
	
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
