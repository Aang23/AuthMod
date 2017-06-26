package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerMovement {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	  public void PlayerMovement(LivingUpdateEvent evt) {
		if(!Main.logged.contains(evt.getEntity().getName()) && evt.getEntity() instanceof EntityPlayer){

			String name = evt.getEntity().getName();
			

			if(evt.getEntity().posX != (Double)Main.posX.get(name)&&evt.getEntity().posY != (Double)Main.posY.get(name)&&evt.getEntity().posZ != (Double)Main.posZ.get(name)){
Double diffex = evt.getEntity().posX - (Double)Main.posX.get(name);
Double diffey = evt.getEntity().posY - (Double)Main.posY.get(name);
Double diffez = evt.getEntity().posZ - (Double)Main.posZ.get(name);

Double dx = Double.parseDouble(diffex.toString().replaceAll("-", ""));
Double dy = Double.parseDouble(diffey.toString().replaceAll("-", ""));
Double dz = Double.parseDouble(diffez.toString().replaceAll("-", ""));


if((dx > 5 | dy > 5 | dz > 5) && Integer.parseInt((String) Main.config.get("allowtp")) == 1){
	Main.posX.put(evt.getEntity().getName(), evt.getEntity().posX);
	Main.posY.put(evt.getEntity().getName(), evt.getEntity().posY);
	Main.posZ.put(evt.getEntity().getName(), evt.getEntity().posZ);
}
				Double x = (Double)Main.posX.get(name);
				Double y = (Double)Main.posY.get(name);
				Double z = (Double)Main.posZ.get(name);
				evt.getEntity().setPositionAndUpdate(x,y,z);
				if(Main.passwords.containsKey(evt.getEntity().getName())){
					evt.getEntity().addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("loginmessage")));
				} else {
				evt.getEntity().addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("registermessage")));
				}
			}
			}
			}
}
