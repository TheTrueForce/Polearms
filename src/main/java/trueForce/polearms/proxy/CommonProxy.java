package trueForce.polearms.proxy;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import trueForce.polearms.EventHandler;
import trueForce.polearms.Polearms;
import trueForce.polearms.item.ModItems;
import trueForce.polearms.network.MessageExtendedReachAttack;



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


	private void registerEventListeners()
	{
		// DEBUG
		Polearms.logger.info("Registering event listeners");
		MinecraftForge.EVENT_BUS.register(new EventHandler());

		// some events, especially tick, are handled on FML bus
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	private void registerNetworkChannel() {
		Polearms.network = NetworkRegistry.INSTANCE.newSimpleChannel(Polearms.NETWORK_CHANNEL_NAME);
		int packetId = 0;
		// register messages from client to server
		Polearms.network.registerMessage(MessageExtendedReachAttack.Handler.class, MessageExtendedReachAttack.class, packetId++, Side.SERVER);
	}
	
	private void registerCrafting() {
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.pole, "#", "#", '#', Items.STICK));
		GameRegistry.addShapedRecipe(ModItems.woodSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.WOODEN_SWORD),
				'$', ModItems.pole);
		GameRegistry.addShapedRecipe(ModItems.stoneSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.STONE_SWORD),
				'$', ModItems.pole);
		GameRegistry.addShapedRecipe(ModItems.ironSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.IRON_SWORD),
				'$', ModItems.pole);
		GameRegistry.addShapedRecipe(ModItems.goldSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.GOLDEN_SWORD),
				'$', ModItems.pole);
		GameRegistry.addShapedRecipe(ModItems.diamondSpear, 
				"#",
				"$",
				"$",
				'#', new ItemStack(Items.DIAMOND_SWORD),
				'$', ModItems.pole);
	}

}
