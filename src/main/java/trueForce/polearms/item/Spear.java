package trueForce.polearms.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class Spear extends ItemSword implements IExtendedReach {
	public Spear(ToolMaterial material) {
		super(material);
		switch (material) {
		case DIAMOND:
			setUnlocalizedName("diamondSpear");
            name = "diamondSpear";
			break;
		case GOLD:
			setUnlocalizedName("goldSpear");
			name = "goldSpear";
			break;
		case IRON:
			setUnlocalizedName("ironSpear");
            name = "ironSpear";
			break;
		case STONE:
			setUnlocalizedName("stoneSpear");
            name = "stoneSpear";
			break;
		case WOOD:
			setUnlocalizedName("woodSpear");
            name = "woodSpear";
			break;
		}
		setCreativeTab(CreativeTabs.COMBAT);
		
	}
	
	public Spear(ToolMaterial material, String domain, String unlocalizedName) {
		super(material);
		setUnlocalizedName(unlocalizedName);
		name = unlocalizedName;
		setCreativeTab(CreativeTabs.COMBAT);
	}

	private static String name;

	public String getName() {
	    return name;
    }

	@Override
	public float getReach() {
		return 7.0F;// Seven blocks of reach, up from the player's usual 5.
	}
}
