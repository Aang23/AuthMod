package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityEvents {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	  public void EntityEvents(BlockEvent.PlaceEvent evt) {
		if(Main.debug==1)System.out.println(evt.getPlayer().getName() + " called PlaceEvent");

		if(!Main.logged.contains(evt.getPlayer().getName())){
			evt.setCanceled(true);
			}
				}
}

/*
int x = (Integer) Main.posx.get(evt.player.getName());
			int y = (Integer) Main.posy.get(evt.player.getName());
			int z = (Integer) Main.posz.get(evt.player.getName());
			evt.player.setPositionAndUpdate(x,y,z);
*/