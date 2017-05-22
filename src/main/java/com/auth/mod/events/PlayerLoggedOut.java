package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerLoggedOut {
	@SubscribeEvent
	  public void PlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent evt) {
		Main.logged.remove(evt.player.getName());
		}
}
