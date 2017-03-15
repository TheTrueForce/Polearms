package trueForce.polearms.network;

import trueForce.polearms.Polearms;
import trueForce.polearms.item.IExtendedReach;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;

/* IMPORTANT - this code has been adapted from tutorial code written for Minecraft 1.8.
 * It looks safe, but I'm not sure. I haven't crashed yet, so it's looking good.
 */

public class MessageExtendedReachAttack implements IMessage 
{
    private int entityId ;

    public MessageExtendedReachAttack() 
    { 
     // need this constructor
    }

    public MessageExtendedReachAttack(int parEntityId) 
    {
     entityId = parEntityId;
        // DEBUG
        //Polearms.logger.info("Constructor");
    }

    @Override
    public void fromBytes(ByteBuf buf) 
    {
     entityId = ByteBufUtils.readVarInt(buf, 4);
     // DEBUG
     //Main.logger.info("fromBytes");
    }

    @Override
    public void toBytes(ByteBuf buf) 
    {
     ByteBufUtils.writeVarInt(buf, entityId, 4);
        // DEBUG
     //Main.logger.info("toBytes encoded");
    }

    public static class Handler implements IMessageHandler<MessageExtendedReachAttack, IMessage> {
    	@Override
    	public IMessage onMessage(final MessageExtendedReachAttack message, MessageContext ctx) {
    		// DEBUG
    		//Main.logger.info("Message received");
    		// Know it will be on the server so make it thread-safe
    		final EntityPlayerMP thePlayer = Polearms.proxy.getPlayerEntityFromContext(ctx);
    		
    		Entity theEntity = thePlayer.worldObj.getEntityByID(message.entityId);
    		// DEBUG
    		//Main.logger.info("Entity = "+theEntity);
            
    		// Need to ensure that hackers can't cause trick kills, 
    		// so double check weapon type and reach
    		if (thePlayer.getCurrentEquippedItem() == null) {
    			return null;
    		}
    		if (thePlayer.getCurrentEquippedItem().getItem() instanceof IExtendedReach) {
    			IExtendedReach theExtendedReachWeapon = (IExtendedReach)thePlayer.getCurrentEquippedItem().getItem();
    			double distanceSq = thePlayer.getDistanceSqToEntity(theEntity);
    			double reachSq =theExtendedReachWeapon.getReach()*theExtendedReachWeapon.getReach();
    			if (reachSq >= distanceSq)
    			{
    				thePlayer.attackTargetEntityWithCurrentItem(theEntity);
    			}
    		}
    		//return; // no response in this case
    		return null; // no response message
    	}
    
    }
} 


