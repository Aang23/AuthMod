package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EntityEvents2 {
	@SubscribeEvent
	  public void EntityEvents(BlockEvent.BreakEvent evt) {
		if(!Main.logged.contains(evt.getPlayer().getName())){
			evt.setCanceled(true);
			}
				}
	public static ITextComponent makesimpletext(String text)
	  {
	    return new TextComponentString(text);
	  }
}

/*
int x = (Integer) Main.posx.get(evt.player.getName());
			int y = (Integer) Main.posy.get(evt.player.getName());
			int z = (Integer) Main.posz.get(evt.player.getName());
			evt.player.setPositionAndUpdate(x,y,z);
*/