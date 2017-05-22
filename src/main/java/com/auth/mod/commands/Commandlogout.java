package com.auth.mod.commands;
import java.awt.TextComponent;

import com.auth.mod.Main;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;


public class Commandlogout extends CommandBase {
	
	@Override
	public String getCommandName()
	{
	return "logout";
	// Name of the command "test" will be called by "/test"
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/logout";
	// Message to show when the user uses "/help test"
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender;
	if( Main.logged.contains(player.getName())){
		Main.logged.remove(player.getName());
		Main.posX.put(player.getName(), player.posX);
		Main.posY.put(player.getName(), player.posY);
		Main.posZ.put(player.getName(), player.posZ);
		player.addChatMessage(new TextComponentString(ChatFormatting.GREEN + "Disconnected"));
	}
	else {
		player.addChatMessage(new TextComponentString(ChatFormatting.RED + "Already disconnected"));
	}
} 
}


