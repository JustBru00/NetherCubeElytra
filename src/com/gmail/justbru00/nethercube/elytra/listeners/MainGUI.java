package com.gmail.justbru00.nethercube.elytra.listeners;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.nethercube.elytra.utils.Messager;

public class MainGUI implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		if (e.getInventory() != null) {
			if (e.getInventory().getName() != null) {
				if (e.getInventory().getName().startsWith(Messager.color("&cCurrency: "))) {
					// Is the main GUI 
					e.setCancelled(true);
					
					if (e.getCurrentItem() != null) {
						ItemStack item = e.getCurrentItem();
						
						List<String> lore = item.getItemMeta().getLore();
						
						if (lore.get(0).contains(Messager.color("UNLOCKED:"))) {
							// Map is unlocked - Teleport them to the start
							return;
						} 
						
						// Not unlocked
						
						
						
					}
				}
			}
		}
		
	}
	
}
