package trueForce.polearms.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import trueForce.polearms.Polearms;
import trueForce.polearms.item.IExtendedReach;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;


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
        //logger.info("Constructor");
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        entityId = ByteBufUtils.readVarInt(buf, 4);
        // DEBUG
        //logger.info("fromBytes");
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeVarInt(buf, entityId, 4);
        // DEBUG
        //logger.info("toBytes encoded");
    }

    public static class Handler implements IMessageHandler<MessageExtendedReachAttack,
            IMessage>
    {
        @Override
        public IMessage onMessage(final MessageExtendedReachAttack message,
                                  MessageContext ctx)
        {
            // DEBUG
            //logger.info("Message received");
            // Know it will be on the server so make it thread-safe
            final EntityPlayerMP thePlayer = Polearms.proxy.getPlayerEntityFromContext(ctx);
            thePlayer.getServer().addScheduledTask(
                    new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Entity theEntity = thePlayer.worldObj.getEntityByID(message.entityId);
                            // DEBUG
                            //logger.info("Entity = "+theEntity);

                            // Need to ensure that hackers can't cause trick kills,
                            // so double check weapon type and reach
                            if (thePlayer.getHeldItemMainhand() == null)
                            {
                                return;
                            }
                            if (thePlayer.getHeldItemMainhand().getItem() instanceof
                                    IExtendedReach)
                            {
                                IExtendedReach theExtendedReachWeapon =
                                        (IExtendedReach)thePlayer.getHeldItemMainhand().
                                                getItem();
                                double distanceSq = thePlayer.getDistanceSqToEntity(
                                        theEntity);
                                double reachSq =theExtendedReachWeapon.getReach()*
                                        theExtendedReachWeapon.getReach();
                                if (reachSq >= distanceSq)
                                {
                                    thePlayer.attackTargetEntityWithCurrentItem(
                                            theEntity);
                                }
                            }
                            return; // no response in this case
                        }
                    }
            );
            return null; // no response message
        }
    }
}