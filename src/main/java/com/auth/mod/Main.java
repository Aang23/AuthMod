package com.auth.mod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;

import com.auth.mod.commands.Commandlogout;
import com.auth.mod.commands.LoginCommand;
import com.auth.mod.commands.RegisterCommand;
import com.auth.mod.commands.See;
import com.auth.mod.commands.Unregister;
import com.auth.mod.commands.changelogin;
import com.auth.mod.commands.rmlogin;
import com.auth.mod.events.ChatEvent;
import com.auth.mod.events.CommandEvents;
import com.auth.mod.events.DropItem;
import com.auth.mod.events.EntityEvents;
import com.auth.mod.events.EntityEvents2;
import com.auth.mod.events.PlayerHurt;
import com.auth.mod.events.PlayerInteract;
import com.auth.mod.events.PlayerLoggedIn;
import com.auth.mod.events.PlayerLoggedOut;
import com.auth.mod.events.PlayerMovement;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


@Mod(modid = Main.modId, name = Main.name, version = Main.version, acceptedMinecraftVersions = "[1.10.2]", acceptableRemoteVersions = "*")
public class Main {

	public static final String modId = "authmod";
	public static final String name = "AuthMod";
	public static final String version = "2.0";
	public static List logged = new ArrayList();
	public static Map time = new HashMap();
	public static Map passwords = new HashMap();
	public static Map posX = new HashMap();
	public static Map posY = new HashMap();
	public static Map posZ = new HashMap();
	public static Map config = new HashMap();
	public static Map ips = new HashMap();
	@Mod.Instance(modId)
	public static Main instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");
        config.put("logout", "1");
        config.put("rmlogin", "1");
        config.put("see", "1");
        config.put("unregister", "1");
        config.put("changelogin", "1");
        config.put("allowtp", "0");
        config.put("nochat", "1");
        config.put("timeout", "60");
        config.put("iplogin", "0");
        
        config.put("wrongpass", "Wrong password.");
        config.put("loginmessage", "Please use /login <password>");
        config.put("iploginmessage", "Sucessfully logged by IP !");
        config.put("registermessage", "Please use /register <password>");
        config.put("notloggedin", "Not logged in.");
        config.put("disconnectedmessage", "Sucessfully disconnected !");
        config.put("loggedmessage", "Sucessfully logged in !");
        config.put("registeredmessage", "Sucessfully registered !");
        config.put("allreadyregistered", "Allready registered !");
        config.put("accountdeleted", "Account deleted !");
        config.put("accountnoexist", "Account does not exist !");
        config.put("passwordchanged", "Password changed !");
        config.put("timeouttext", "Too long to login !");
		}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		File f = new File("config/AuthMod.cfg");
		if(f.exists() && !f.isDirectory()) { 

		
		Map<String, String> ldapContent = new HashMap<String, String>();
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config/AuthMod.cfg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String key : properties.stringPropertyNames()) {
		   ldapContent.put(key, properties.get(key).toString());
		}
		config = ldapContent;
		
		}
		else {
			
			Map<String, String> ldapContent = config;
			Properties properties = new Properties();

			for (Map.Entry<String,String> entry : ldapContent.entrySet()) {
			    properties.put(entry.getKey(), entry.getValue());
			}

			try {
				properties.store(new FileOutputStream("config/AuthMod.cfg"), null);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		Map<String, String> ldapContent = new HashMap<String, String>();
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("passwords.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String key : properties.stringPropertyNames()) {
		   ldapContent.put(key, properties.get(key).toString());
		}
		passwords = ldapContent;
		
		int logout = Integer.parseInt((String) config.get("logout"));
		int unregister = Integer.parseInt((String) config.get("unregister"));
		int rmlogin = Integer.parseInt((String) config.get("rmlogin"));
		int see = Integer.parseInt((String) config.get("see"));
		int changelogin = Integer.parseInt((String) config.get("changelogin"));
		
	event.registerServerCommand(new LoginCommand());
	if(see==1) event.registerServerCommand(new See());
	if(changelogin==1) event.registerServerCommand(new changelogin());
	event.registerServerCommand(new RegisterCommand());
	if(logout==1) event.registerServerCommand(new Commandlogout());
	if(rmlogin==1) event.registerServerCommand(new rmlogin());
	if(unregister==1) event.registerServerCommand(new Unregister());
	MinecraftForge.EVENT_BUS.register(new PlayerLoggedIn());
	MinecraftForge.EVENT_BUS.register(new PlayerLoggedOut());
	MinecraftForge.EVENT_BUS.register(new EntityEvents());
	MinecraftForge.EVENT_BUS.register(new EntityEvents2());
	MinecraftForge.EVENT_BUS.register(new CommandEvents());
	MinecraftForge.EVENT_BUS.register(new PlayerMovement());
	MinecraftForge.EVENT_BUS.register(new PlayerInteract());
	MinecraftForge.EVENT_BUS.register(new PlayerHurt());
	MinecraftForge.EVENT_BUS.register(new DropItem());
	MinecraftForge.EVENT_BUS.register(new ChatEvent());
	
	Timer timer = new Timer();
	timer.schedule(new Timeout(), 0, 1000);
	}
	
	
	@Mod.EventHandler
	  public void onPlayerEvent(PlayerEvent evt) {
		evt.setCanceled(true);
		}
	public static ITextComponent makesimpletext(String text)
	  {
	    return new TextComponentString(text);
	  }
}
