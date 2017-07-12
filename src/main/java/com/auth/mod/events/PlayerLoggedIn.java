package com.auth.mod.events;

import java.lang.reflect.Field;

import com.auth.mod.Main;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketPlayerListHeaderFooter;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.server.FMLServerHandler;

public class PlayerLoggedIn {
	@SubscribeEvent(priority = EventPriority.LOW)
	  public void PlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent evt) {
		if(Main.debug==1)System.out.println(evt.player.getName() + " called PlayentLoggedIn");
		Main.posX.put(evt.player.getName(), evt.player.posX);
		Main.posY.put(evt.player.getName(), evt.player.posY);
		Main.posZ.put(evt.player.getName(), evt.player.posZ);
		Main.time.put(evt.player.getName(), 0);
		
		MinecraftServer minecraftServer = FMLServerHandler.instance().getServer();
		String brut = minecraftServer.getPlayerList().getPlayerByUsername(evt.player.getName()).connection.getNetworkManager().getRemoteAddress().toString().replaceAll("/", "");
		int lenght = brut.length();
		brut = brut.substring(0, lenght-6);
		
		if(Integer.parseInt((String) Main.config.get("iplogin")) > 0 && Main.ips.containsKey(brut)){
			Main.logged.add(evt.player.getName());
			evt.player.addChatMessage(new TextComponentString(TextFormatting.GREEN + (String)Main.config.get("iploginmessage")));	
			Main.ips.remove(brut);
			Main.time.remove(evt.player.getName());
		}
		
		if(!Main.logged.contains(evt.player.getName())){
		if(Main.passwords.containsKey(evt.player.getName())){
		evt.player.addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("loginmessage")));
		} else {
		evt.player.addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("registermessage")));
		}
		}
		
	}
}
