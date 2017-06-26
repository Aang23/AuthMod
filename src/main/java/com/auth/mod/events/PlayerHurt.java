package com.auth.mod.events;

import com.auth.mod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerHurt {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	  public void PlayerInteraction(LivingHurtEvent evt) {
		if(evt.getEntity() instanceof EntityPlayer && !Main.logged.contains(evt.getEntity().getName())){
			evt.setCanceled(true);
		}
	}
}
