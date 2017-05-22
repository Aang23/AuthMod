package com.auth.mod.commands;
import com.auth.mod.Main;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;


public class LoginCommand extends CommandBase {
	
	@Override
	public String getCommandName()
	{
	return "login";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/login <password>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender;
if(Main.passwords.containsKey(player.getName())){
	if( Main.passwords.get(player.getName()).equals(args[0])){
		Main.logged.add(player.getName());
		player.addChatMessage(new TextComponentString(ChatFormatting.GREEN + "Logged in !"));
	}
	else {
		player.addChatMessage(new TextComponentString(ChatFormatting.RED + "Wrong password."));
	}
} else {
	player.addChatMessage(new TextComponentString(ChatFormatting.RED + "Not registered, please use /register."));
}
	}
}

