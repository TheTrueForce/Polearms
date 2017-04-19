package trueForce.polearms.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Pole extends Item {
    Pole() {
        setUnlocalizedName("pole");
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    private final String name = "pole";

    public String getName() {
        return name;
    }
}
