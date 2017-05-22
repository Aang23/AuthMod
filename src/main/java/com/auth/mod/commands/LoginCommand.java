package com.auth.mod.commands;
import java.awt.TextComponent;

import com.auth.mod.Main;

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


public class LoginCommand extends CommandBase {
	
	@Override
	public String getCommandName()
	{
	return "login";
	// Name of the command "test" will be called by "/test"
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/login <password>";
	// Message to show when the user uses "/help test"
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender;
if(Main.passwords.containsKey(player.getName())){
	if( Main.passwords.get(player.getName()).equals(args[0])){
		Main.logged.add(player.getName());
		player.addChatMessage(makesimpletext("Logged in."));
	}
	else {
		player.addChatMessage(makesimpletext("Wrong password"));
	}
} else {
	player.addChatMessage(makesimpletext("Not registered."));
}
	}
	
	public static ITextComponent makesimpletext(String text)
	  {
	    return new TextComponentString(text);
	  }
}


