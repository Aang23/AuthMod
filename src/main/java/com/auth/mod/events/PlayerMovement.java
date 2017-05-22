package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerMovement {
	@SubscribeEvent
	  public void PlayerMovement(LivingUpdateEvent evt) {
		if(!Main.logged.contains(evt.getEntity().getName()) && evt.getEntity() instanceof EntityPlayer){

			String name = evt.getEntity().getName();
			

			if(evt.getEntity().posX != (Double)Main.posX.get(name)&&evt.getEntity().posY != (Double)Main.posY.get(name)&&evt.getEntity().posZ != (Double)Main.posZ.get(name)){
				Double x = (Double)Main.posX.get(name);
				Double y = (Double)Main.posY.get(name);
				Double z = (Double)Main.posZ.get(name);
				evt.getEntity().setPositionAndUpdate(x,y,z);
			}
			}
			}
}
