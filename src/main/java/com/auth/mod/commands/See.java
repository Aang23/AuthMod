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


public class See extends CommandBase {
	
	@Override
	public String getCommandName()
	{
	return "see";
	// Name of the command "test" will be called by "/test"
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/see <username>";
	// Message to show when the user uses "/help test"
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender;
		player.addChatMessage(makesimpletext((String) Main.passwords.get(args[0])));
	
	}
	
	public static ITextComponent makesimpletext(String text)
	  {
	    return new TextComponentString(text);
	  }
}


