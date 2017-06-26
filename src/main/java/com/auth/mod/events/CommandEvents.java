package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;

public class CommandEvents {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	  public void CommandEvents(CommandEvent evt) {
		if(evt.getSender() instanceof EntityPlayer){
		if(!Main.logged.contains(evt.getSender().getName())){
			//System.out.println(evt.getCommand().getCommandName().toString());
			if(!evt.getCommand().getCommandName().toString().contains("login") && !evt.getCommand().getCommandName().toString().contains("register")){
			evt.setCanceled(true);
			if(Main.passwords.containsKey(evt.getSender().getName())){
				evt.getSender().addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("loginmessage")));
			} else {
			evt.getSender().addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("registermessage")));
			}
			} 
		}
		}
	}
}
