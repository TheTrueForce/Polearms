package trueForce.polearms.item;

import trueForce.polearms.Polearms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class Spear extends ItemSword implements IExtendedReach {
	public Spear(ToolMaterial material) {
		super(material);
		switch (material) {
		case EMERALD:
			setUnlocalizedName("diamondSpear");
			setTextureName(Polearms.DOMAIN + ":" + "diamondSpear");
			break;
		case GOLD:
			setUnlocalizedName("goldSpear");
			setTextureName(Polearms.DOMAIN + ":" + "goldSpear");
			break;
		case IRON:
			setUnlocalizedName("ironSpear");
			setTextureName(Polearms.DOMAIN + ":" + "ironSpear");
			break;
		case STONE:
			setUnlocalizedName("stoneSpear");
			setTextureName(Polearms.DOMAIN + ":" + "stoneSpear");
			break;
		case WOOD:
			setUnlocalizedName("woodSpear");
			setTextureName(Polearms.DOMAIN + ":" + "woodSpear");
			break;
		}
		setCreativeTab(CreativeTabs.tabCombat);
		
	}
	
	public Spear(ToolMaterial material, String domain, String unlocalizedName) {
		super(material);
		setUnlocalizedName(unlocalizedName);
		setTextureName(domain + ":" + unlocalizedName);
		setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	public float getReach() {
		return 7.0F;// Seven blocks of reach
	}
}
