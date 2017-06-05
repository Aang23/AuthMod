package com.auth.mod.events;

import com.auth.mod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DropItem {
	@SubscribeEvent
	  public void DropItems(ItemTossEvent evt) {
			
			if(!Main.logged.contains(evt.getPlayer().getName())){
			ItemStack itemStack = evt.getEntityItem().getEntityItem();
			evt.setCanceled(true);
			evt.getPlayer().inventory.addItemStackToInventory(itemStack);
			}
			
		
	}
}
