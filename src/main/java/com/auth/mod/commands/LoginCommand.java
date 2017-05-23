package com.auth.mod.commands;
import com.auth.mod.Main;
import net.minecraft.util.text.TextFormatting;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;


public class LoginCommand extends CommandBase implements ICommand {
	
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
	public boolean checkPermission(MinecraftServer server, ICommandSender sender)
	{
		return true;
	}

	 public boolean func_184882_a(MinecraftServer server, ICommandSender sender)
	  {
	    return true;
	  }
  
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender;
if(Main.passwords.containsKey(player.getName())){
	if( Main.passwords.get(player.getName()).equals(args[0])){
		Main.logged.add(player.getName());
		player.addChatMessage(new TextComponentString(TextFormatting.GREEN + "Logged in !"));
	}
	else {
		player.addChatMessage(new TextComponentString(TextFormatting.RED + "Wrong password."));
	}
} else {
	player.addChatMessage(new TextComponentString(TextFormatting.RED + "Not registered, please use /register."));
}
	}
}


