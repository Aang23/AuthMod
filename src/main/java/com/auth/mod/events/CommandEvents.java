package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;

public class CommandEvents {
	@SubscribeEvent
	  public void CommandEvents(CommandEvent evt) {
		if(evt.getSender() instanceof EntityPlayer){
		if(!Main.logged.contains(evt.getSender().getName())){
			if(!evt.getCommand().getCommandName().contains("login") && !evt.getCommand().getCommandName().contains("register")){
			evt.setCanceled(true);
			} 
		}
		}
	}
	public static ITextComponent makesimpletext(String text)
	  {
	    return new TextComponentString(text);
	  }
}