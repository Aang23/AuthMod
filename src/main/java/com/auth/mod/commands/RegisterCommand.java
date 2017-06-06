package com.auth.mod.commands;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import com.auth.mod.Main;
import net.minecraft.util.text.TextFormatting;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;


public class RegisterCommand extends CommandBase implements ICommand {
	
	@Override
	public String getCommandName()
	{
	return "register";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/register <password>";	}

	
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
		// Turn the sender into a player entity
		if(!Main.passwords.containsKey(player.getName())){
		Main.passwords.put(player.getName(), args[0]);
		player.addChatMessage(new TextComponentString(TextFormatting.GREEN + (String)Main.config.get("registeredmessage")));
		Main.logged.add(player.getName());
		Main.time.remove(player.getName());
		} else {
			player.addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("allreadyregistered")));
		}
		
		try{

    		File file = new File("passwords.properties");

    		if(file.delete()){
    			System.out.println(file.getName() + "Removed passwords list for update");
    		}else{
    			System.out.println("A AuthMod operation failed !");
    		}

    	}catch(Exception e){

    		e.printStackTrace();
         }
		
		Map<String, String> ldapContent = Main.passwords;
		Properties properties = new Properties();

		for (Map.Entry<String,String> entry : ldapContent.entrySet()) {
		    properties.put(entry.getKey(), entry.getValue());
		}

		try {
			properties.store(new FileOutputStream("passwords.properties"), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


