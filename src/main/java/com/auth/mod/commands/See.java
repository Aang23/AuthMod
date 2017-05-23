package com.auth.mod.commands;
import com.auth.mod.Main;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;


public class See extends CommandBase {
	
	@Override
	public String getCommandName()
	{
	return "see";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/see <username>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender;
		if(player.canCommandSenderUseCommand(3, "com.auth.mod.commands.see")){
		player.addChatMessage(makesimpletext((String) Main.passwords.get(args[0])));
	
	}
	}
	public static ITextComponent makesimpletext(String text)
	  {
	    return new TextComponentString(text);
	  }
}


