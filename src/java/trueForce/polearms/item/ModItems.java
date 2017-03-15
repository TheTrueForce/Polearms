package trueForce.polearms.item;

import trueForce.polearms.Polearms;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

public class ModItems {
	
	private static Item itemIronSpear = new Spear(ToolMaterial.IRON);
	private static Item itemWoodSpear = new Spear(ToolMaterial.WOOD);
	private static Item itemStoneSpear = new Spear(ToolMaterial.STONE);
	private static Item itemDiamondSpear = new Spear(ToolMaterial.EMERALD);
	private static Item itemGoldSpear = new Spear(ToolMaterial.GOLD);
	private static Item itemPole = new Item().setUnlocalizedName("pole").setTextureName(Polearms.DOMAIN + ":pole").setCreativeTab(CreativeTabs.tabMaterials);
	
	public static ItemStack woodSpear;
	public static ItemStack stoneSpear;
	public static ItemStack ironSpear;
	public static ItemStack goldSpear;
	public static ItemStack diamondSpear;
	public static ItemStack pole;
	public static void registerItems() {
		GameRegistry.registerItem(itemIronSpear, "ironSpear");
		GameRegistry.registerItem(itemWoodSpear, "woodSpear");
		GameRegistry.registerItem(itemStoneSpear, "stoneSpear");
		GameRegistry.registerItem(itemDiamondSpear, "diamondSpear");
		GameRegistry.registerItem(itemGoldSpear, "goldSpear");
		GameRegistry.registerItem(itemPole, "pole");
		
		pole = new ItemStack(itemPole);
		ironSpear = new ItemStack(itemIronSpear);
		woodSpear = new ItemStack(itemWoodSpear);
		stoneSpear = new ItemStack(itemStoneSpear);
		diamondSpear = new ItemStack(itemDiamondSpear);
		goldSpear = new ItemStack(itemGoldSpear);
	}
}
