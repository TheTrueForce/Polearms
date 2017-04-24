package trueForce.polearms.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import trueForce.polearms.Polearms;

public class Spear extends ItemSword implements IExtendedReach {
	public Spear(ToolMaterial material) {
		super(material);
		switch (material) {
		case DIAMOND:
			setUnlocalizedName("diamondspear");
            name = "diamondspear";
			break;
		case GOLD:
			setUnlocalizedName("goldspear");
			name = "goldspear";
			break;
		case IRON:
			setUnlocalizedName("ironspear");
            name = "ironspear";
			break;
		case STONE:
			setUnlocalizedName("stonespear");
            name = "stonespear";
			break;
		case WOOD:
			setUnlocalizedName("woodspear");
            name = "woodspear";
			break;
		}
		setCreativeTab(CreativeTabs.COMBAT);

	}
	
	public Spear(ToolMaterial material, String domain, String unlocalizedName) {
		super(material);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(Polearms.MODID + ":" + unlocalizedName);
		name = unlocalizedName;
	}

	protected static String name;

	public String getName() {
	    return name;
    }

	@Override
	public float getReach() {
		return 7.0F;// Seven blocks of reach, up from the player's usual 5.
	}
}
