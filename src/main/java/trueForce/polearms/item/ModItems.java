package trueForce.polearms.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import trueForce.polearms.Polearms;

public class ModItems {
	
	private static Item itemIronSpear       = new Spear(ToolMaterial.IRON);
	private static Item itemWoodSpear       = new Spear(ToolMaterial.WOOD);
	private static Item itemStoneSpear      = new Spear(ToolMaterial.STONE);
	private static Item itemDiamondSpear    = new Spear(ToolMaterial.DIAMOND);
	private static Item itemGoldSpear       = new Spear(ToolMaterial.GOLD);
	private static Item itemPole            = new Pole();
	
	public static ItemStack woodSpear       = new ItemStack(itemWoodSpear);
	public static ItemStack stoneSpear      = new ItemStack(itemStoneSpear);
	public static ItemStack ironSpear       = new ItemStack(itemIronSpear);
	public static ItemStack goldSpear       = new ItemStack(itemGoldSpear);
	public static ItemStack diamondSpear    = new ItemStack(itemDiamondSpear);
	public static ItemStack pole            = new ItemStack(itemPole);

	public static void registerItems(RegistryEvent.Register<Item> event) {

		event.getRegistry().register(itemWoodSpear);
        event.getRegistry().register(itemStoneSpear);
        event.getRegistry().register(itemIronSpear);
        event.getRegistry().register(itemGoldSpear);
        event.getRegistry().register(itemDiamondSpear);
        event.getRegistry().register(itemPole);
	}

	public static void setupCreativeTabs() {
        itemWoodSpear.setCreativeTab(CreativeTabs.COMBAT);
        itemStoneSpear.setCreativeTab(CreativeTabs.COMBAT);
        itemIronSpear.setCreativeTab(CreativeTabs.COMBAT);
        itemGoldSpear.setCreativeTab(CreativeTabs.COMBAT);
        itemDiamondSpear.setCreativeTab(CreativeTabs.COMBAT);
	    itemPole.setCreativeTab(CreativeTabs.MATERIALS);
    }
	public static void registerItemRenderer() {
		ModelLoader.setCustomModelResourceLocation(pole.getItem(), 0, new ModelResourceLocation(Polearms.MODID + ":" + pole.getItem().getUnlocalizedName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(woodSpear.getItem(), 0, new ModelResourceLocation(Polearms.MODID + ":" + woodSpear.getItem().getUnlocalizedName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(stoneSpear.getItem(), 0, new ModelResourceLocation(Polearms.MODID + ":" + stoneSpear.getItem().getUnlocalizedName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(ironSpear.getItem(), 0, new ModelResourceLocation(Polearms.MODID + ":" + ironSpear.getItem().getUnlocalizedName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(goldSpear.getItem(), 0, new ModelResourceLocation(Polearms.MODID + ":" + goldSpear.getItem().getUnlocalizedName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(diamondSpear.getItem(), 0, new ModelResourceLocation(Polearms.MODID + ":" + diamondSpear.getItem().getUnlocalizedName(), "inventory"));
	}
}
