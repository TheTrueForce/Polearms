package trueForce.polearms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import trueForce.polearms.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Polearms.MODID, name = Polearms.MODNAME, version = Polearms.VERSION)
public class Polearms {
	
	public static final String MODID = "Polearms";
	public static final String DOMAIN = "polearms";
	public static final String MODNAME = "Polearms";
	public static final String VERSION = "1.3";
	public static final String NETWORK_CHANNEL_NAME = "polearms";

	@Instance
	public static Polearms instance = new Polearms();
	
	@SidedProxy(clientSide = "trueForce.polearms.proxy.ClientProxy", serverSide = "trueForce.polearms.proxy.ServerProxy")
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
