package trueForce.polearms.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import trueForce.polearms.item.ModItems;


public class ItemRenderRegister {
    public static void registerItemRenderer() {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(ModItems.woodSpear.getItem(), 0, new ModelResourceLocation("polearms:woodSpear", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(ModItems.stoneSpear.getItem(), 0, new ModelResourceLocation("polearms:stoneSpear", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(ModItems.ironSpear.getItem(), 0, new ModelResourceLocation("polearms:ironSpear", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(ModItems.goldSpear.getItem(), 0, new ModelResourceLocation("polearms:goldSpear", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(ModItems.diamondSpear.getItem(), 0, new ModelResourceLocation("polearms:diamondSpear", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(ModItems.pole.getItem(), 0, new ModelResourceLocation("polearms:pole", "inventory"));
    }
}
