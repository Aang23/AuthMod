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
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;


public class rmlogin extends CommandBase {
	
	@Override
	public String getCommandName()
	{
	return "rmlogin";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/rmlogin <username>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender.canCommandSenderUseCommand(3, "com.auth.mod.commands.rmlogin")){
		EntityPlayer player = (EntityPlayer) sender;
		if(Main.passwords.containsKey(args[0])){
			Main.passwords.remove(args[0]);
			player.addChatMessage(new TextComponentString(TextFormatting.GREEN + "Succeflly deleted."));
	if( Main.logged.contains(args[0])){
		Main.logged.remove(args[0]);
	}
} else player.addChatMessage(new TextComponentString(TextFormatting.RED + "Account does not exist."));
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


