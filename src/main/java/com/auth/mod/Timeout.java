package com.auth.mod;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.server.FMLServerHandler;

public class Timeout extends TimerTask {

	@Override
	public void run() {
		MinecraftServer minecraftServer = FMLServerHandler.instance().getServer();

		
		List list = new ArrayList(Main.time.keySet());
		list.add("");
		for(int i = 0; i<= (list.size()-1); i++){
        String name = (String) list.get(i);
        if(name != ""){
        	
        	
        	int val = (Integer) Main.time.get(name);
        	val ++;
        	Main.time.replace(name, val);
        	
        	
        	if(val >= Integer.parseInt((String) Main.config.get("timeout")) && Integer.parseInt((String) Main.config.get("timeout")) != 0){
        		minecraftServer.getServer().getCommandManager().executeCommand(minecraftServer, "kick " + name + " " + (String) Main.config.get("timeouttext"));
        	}
        	
        }
		}
		
		List list2 = new ArrayList(Main.ips.keySet());
		list2.add("");
		for(int i = 0; i<= (list2.size()-1); i++){
	        String ip = (String) list2.get(i);
	        if(ip != ""){
	        	
	        	int val = (Integer) Main.ips.get(ip);
	        	val ++;
	        	Main.ips.replace(ip, val);
	        	if(val >= Integer.parseInt((String) Main.config.get("iplogin")) && Integer.parseInt((String) Main.config.get("iplogin")) > 0){
	        		Main.ips.remove(ip);
	        	}
	        }
			}
		
		
	}

}
