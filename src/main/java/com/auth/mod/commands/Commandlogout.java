package com.auth.mod.commands;
import com.auth.mod.Main;
import net.minecraft.util.text.TextFormatting;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;


public class Commandlogout extends CommandBase {
	
	@Override
	public String getCommandName()
	{
	return "logout";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/logout";
	}
	 public boolean func_184882_a(MinecraftServer server, ICommandSender sender)
	  {
	    return true;
	  }
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender;
		    System.out.println("Has permission !");
		    if( Main.logged.contains(player.getName())){
				Main.logged.remove(player.getName());
				Main.posX.put(player.getName(), player.posX);
				Main.posY.put(player.getName(), player.posY);
				Main.posZ.put(player.getName(), player.posZ);
				player.addChatMessage(new TextComponentString(TextFormatting.GREEN + "Disconnected"));
			}
			else {
				player.addChatMessage(new TextComponentString(TextFormatting.RED + "Already disconnected"));
			}
		}
	
} 
	



