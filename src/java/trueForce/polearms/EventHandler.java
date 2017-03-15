package trueForce.polearms;

import java.util.List;

import trueForce.polearms.item.IExtendedReach;
import trueForce.polearms.network.MessageExtendedReachAttack;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.MouseEvent;

public class EventHandler {


@SideOnly(Side.CLIENT)
@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
public void onEvent(MouseEvent event)
{ 
	//Main.logger.info("MouseEvent Fired");
    if (event.button == 0 && event.buttonstate)
    {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer thePlayer = mc.thePlayer;
        if (thePlayer != null)
        {
            ItemStack itemstack = thePlayer.getCurrentEquippedItem();
            IExtendedReach ieri;
            if (itemstack != null)
            {
                if (itemstack.getItem() instanceof IExtendedReach)
                {
                    ieri = (IExtendedReach) itemstack.getItem();
                } else
                {
                    ieri = null;
                }
   
                if (ieri != null)
                {
                    float reach = ieri.getReach();
                    MovingObjectPosition mov = getMouseOverExtended(reach); 
                      
                    if (mov != null)
                    {
                        if (mov.entityHit != null && mov.entityHit.hurtResistantTime == 0)
                        {
                            if (mov.entityHit != thePlayer )
                            {
                                Polearms.network.sendToServer(new MessageExtendedReachAttack(

                                      mov.entityHit.getEntityId()));
                            }
                        }
                    }
                }
            }
        }
    }
}
        
// This is mostly copied from the EntityRenderer#getMouseOver() method
public static MovingObjectPosition getMouseOverExtended(float dist)
{
    Minecraft mc = FMLClientHandler.instance().getClient();
    EntityPlayer theRenderViewEntity = (EntityPlayer) mc.renderViewEntity;
    AxisAlignedBB theViewBoundingBox = AxisAlignedBB.getBoundingBox(
            theRenderViewEntity.posX-0.5D, theRenderViewEntity.posY-0.0D, theRenderViewEntity.posZ-0.5D,
            theRenderViewEntity.posX+0.5D, theRenderViewEntity.posY+1.5D, theRenderViewEntity.posZ+0.5D);
    MovingObjectPosition returnMOP = null;
    if (mc.theWorld != null)
    {
        double var2 = dist;
        returnMOP = theRenderViewEntity.rayTrace(var2, 0);
        double calcdist = var2;
        Vec3 pos = theRenderViewEntity.getPosition(0);
        var2 = calcdist;
        if (returnMOP != null)
        {
            calcdist = returnMOP.hitVec.distanceTo(pos);
        }
         
        Vec3 lookvec = theRenderViewEntity.getLook(0);
        Vec3 var8 = pos.addVector(lookvec.xCoord * var2, 

              lookvec.yCoord * var2, 

              lookvec.zCoord * var2);
        Entity pointedEntity = null;
        float var9 = 1.0F;
        @SuppressWarnings("unchecked")
        List<Entity> list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(theRenderViewEntity, theViewBoundingBox.addCoord(lookvec.xCoord * var2, 
        		lookvec.yCoord * var2, lookvec.zCoord * var2).expand(var9, var9, var9));
        double d = calcdist;
            
        for (Entity entity : list)
        {
            if (entity.canBeCollidedWith())
            {
                float bordersize = entity.getCollisionBorderSize();
                AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(entity.posX-entity.width/2, entity.posY, entity.posZ-entity.width/2, 
                		entity.posX+entity.width/2, entity.posY+entity.height, entity.posZ+entity.width/2);
                aabb.expand(bordersize, bordersize, bordersize);
                MovingObjectPosition mop0 = aabb.calculateIntercept(pos, var8);
                    
                if (aabb.isVecInside(pos))
                {
                    if (0.0D < d || d == 0.0D)
                    {
                        pointedEntity = entity;
                        d = 0.0D;
                    }
                } else if (mop0 != null)
                {
                    double d1 = pos.distanceTo(mop0.hitVec);
                        
                    if (d1 < d || d == 0.0D)
                    {
                        pointedEntity = entity;
                        d = d1;
                    }
                }
            }
        }
           
        if (pointedEntity != null && (d < calcdist || returnMOP == null))
        {
             returnMOP = new MovingObjectPosition(pointedEntity);
        }

    }
    return returnMOP;
}


}
