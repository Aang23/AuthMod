package com.auth.mod.events;

import com.auth.mod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.server.FMLServerHandler;

public class DropItem {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	  public void DropItems(ItemTossEvent evt) {
			
			if(!Main.logged.contains(evt.getPlayer().getName()) && Main.passwords.containsKey(evt.getPlayer().getName())){
				
			ItemStack itemStack = evt.getEntityItem().getEntityItem();
            evt.setCanceled(true);
            evt.getPlayer().inventory.addItemStackToInventory(itemStack);
			}
			
		
	}
}
