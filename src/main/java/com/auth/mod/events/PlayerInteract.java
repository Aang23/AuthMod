package com.auth.mod.events;

import com.auth.mod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerInteract {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	  public void PlayerInteraction(PlayerInteractEvent evt) {
		if(Main.debug==1)System.out.println(evt.getEntity().getName() + " called InteractEvent  " + evt.getEntity().toString());
		if(evt.getEntity() instanceof EntityPlayer && !Main.logged.contains(evt.getEntity().getName())){
			
			evt.setCanceled(true);
			if(Main.passwords.containsKey(evt.getEntityPlayer().getName())){
				evt.getEntityPlayer().addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("loginmessage")));
			} else {
			evt.getEntityPlayer().addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("registermessage")));
			}
		}
	}
}
