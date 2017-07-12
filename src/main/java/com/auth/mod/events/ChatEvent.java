package com.auth.mod.events;

import com.auth.mod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatEvent {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	  public void ChatEvent(ServerChatEvent evt) {
		
		if(Main.debug==1)System.out.println(evt.getPlayer().getName() + " called ChatEvent");

		
		if(evt.getPlayer() instanceof EntityPlayer && !Main.logged.contains(evt.getPlayer().getName()) && Integer.parseInt((String) Main.config.get("nochat")) == 1){
			evt.setCanceled(true);
			if(Main.passwords.containsKey(evt.getPlayer().getName())){
			evt.getPlayer().addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("loginmessage")));
		} else {
		evt.getPlayer().addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("registermessage")));
		}
		}
	}
}
