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
import java.util.Scanner;
import java.util.StringTokenizer;

import com.auth.mod.commands.Commandlogout;
import com.auth.mod.commands.LoginCommand;
import com.auth.mod.commands.RegisterCommand;
import com.auth.mod.commands.See;
import com.auth.mod.events.CommandEvents;
import com.auth.mod.events.EntityEvents;
import com.auth.mod.events.EntityEvents2;
import com.auth.mod.events.PlayerLoggedIn;
import com.auth.mod.events.PlayerLoggedOut;
import com.auth.mod.events.PlayerMove;
import com.auth.mod.events.PlayerMovement;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import ibxm.Player;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent.Entity;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


@Mod(modid = Main.modId, name = Main.name, version = Main.version, acceptedMinecraftVersions = "[1.10.2]", acceptableRemoteVersions = "*")
public class Main {

	public static final String modId = "authmod";
	public static final String name = "AuthMod";
	public static final String version = "1.0.0";
	public static List logged = new ArrayList();
	public static Map passwords = new HashMap();
	public static Map posX = new HashMap();
	public static Map posY = new HashMap();
	public static Map posZ = new HashMap();
	@Mod.Instance(modId)
	public static Main instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");

		}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
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
		
	event.registerServerCommand(new LoginCommand());
	event.registerServerCommand(new See());
	event.registerServerCommand(new RegisterCommand());
	event.registerServerCommand(new Commandlogout());
	MinecraftForge.EVENT_BUS.register(new PlayerLoggedIn());
	MinecraftForge.EVENT_BUS.register(new PlayerLoggedOut());
	MinecraftForge.EVENT_BUS.register(new PlayerMove());
	MinecraftForge.EVENT_BUS.register(new EntityEvents());
	MinecraftForge.EVENT_BUS.register(new EntityEvents2());
	MinecraftForge.EVENT_BUS.register(new CommandEvents());
	MinecraftForge.EVENT_BUS.register(new PlayerMovement());
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
