package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerMove {
	@SubscribeEvent
	  public void PlayerMove(PlayerEvent evt) {
		if(!Main.logged.contains(evt.player.getName())){
			//evt.setCanceled(true);

			}
				}
	public static ITextComponent makesimpletext(String text)
	  {
	    return new TextComponentString(text);
	  }
}
