package trueForce.polearms.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import trueForce.polearms.Polearms;

import static trueForce.polearms.Polearms.MODID;

public class Pole extends Item {
    Pole() {
        setUnlocalizedName("pole");
        setRegistryName("pole");
    }

    private final String name = "pole";

    public String getName() {
        return name;
    }
}
