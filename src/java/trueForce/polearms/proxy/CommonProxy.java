package trueForce.polearms.proxy;

import trueForce.polearms.EventHandler;
import trueForce.polearms.Polearms;
import trueForce.polearms.item.ModItems;
import trueForce.polearms.network.MessageExtendedReachAttack;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.registerItems();
		
	}
	
	public void init(FMLInitializationEvent e) {
	registerNetworkChannel();
	registerEventListeners();
	registerCrafting();
	
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}

	public EntityPlayerMP getPlayerEntityFromContext(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity; // fingers crossed this works... It does. Probably not the best way of doing it, tho
	}


	public void registerEventListeners() 
	{
		// DEBUG
		Polearms.logger.info("Registering event listeners");
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		//MinecraftForge.TERRAIN_GEN_BUS.register(new WildAnimalsTerrainGenEventHandler());

		//MinecraftForge.ORE_GEN_BUS.register(new WildAnimalsOreGenEventHandler());        

		// some events, especially tick, are handled on FML bus
		FMLCommonHandler.instance().bus().register(new EventHandler());
	}
	
	public void registerNetworkChannel() {
		Polearms.network = NetworkRegistry.INSTANCE.newSimpleChannel(Polearms.NETWORK_CHANNEL_NAME);
		int packetId = 0;
		// register messages from client to server
		Polearms.network.registerMessage(MessageExtendedReachAttack.Handler.class, MessageExtendedReachAttack.class, packetId++, Side.SERVER);
	}
	
	public void registerCrafting() {
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.pole, "#", "#", '#', Items.stick));
		GameRegistry.addShapedRecipe(ModItems.woodSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.wooden_sword),
				'$', ModItems.pole);
		GameRegistry.addShapedRecipe(ModItems.stoneSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.stone_sword),
				'$', ModItems.pole);
		GameRegistry.addShapedRecipe(ModItems.ironSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.iron_sword),
				'$', ModItems.pole);
		GameRegistry.addShapedRecipe(ModItems.goldSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.golden_sword),
				'$', ModItems.pole);
		GameRegistry.addShapedRecipe(ModItems.diamondSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.diamond_sword),
				'$', ModItems.pole);
	}

}
