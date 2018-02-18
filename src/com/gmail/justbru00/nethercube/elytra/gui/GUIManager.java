package com.gmail.justbru00.nethercube.elytra.gui;


import java.util.ArrayList;
import java.util.List;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.nethercube.elytra.data.PlayerData;
import com.gmail.justbru00.nethercube.elytra.data.PlayerMapData;
import com.gmail.justbru00.nethercube.elytra.map.Map;
import com.gmail.justbru00.nethercube.elytra.map.MapManager;
import com.gmail.justbru00.nethercube.elytra.utils.ItemBuilder;
import com.gmail.justbru00.nethercube.elytra.utils.Messager;

public class GUIManager {

	private static ItemStack borderGlass;
	
	public static void init() {
		
		borderGlass = new ItemBuilder(Material.STAINED_GLASS_PANE).setDataValue(7).setName("&r").build();
		
	}
	
	/**
	 * Opens the main GUI for map selection, unlocking, and instant teleporting.
	 * Players can left click to teleport to the start of unlocked maps
	 * Players can right click to purchase locked maps
	 * @param p
	 */
	public static void openMainGUI(Player p) {
		
		PlayerData pd = PlayerData.getDataFor(p);
		
		Inventory inv = Bukkit.createInventory(null, 54, Messager.color("&cCurrency: " + pd.getCurrency()));
		
		// Set the border glass
		// 0-9, 10,18,19,27,28,36,37,45,46-54 minus one for all these
		
		Integer[] borderSlots = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53};
		
		for (Integer slot : borderSlots) {
			inv.setItem(slot, borderGlass);
		}
		
		// Fill the maps in
		
	}
	
	private ItemStack getMapItemFor(Player p, String mapInternalName) {
		
		PlayerData pd = PlayerData.getDataFor(p);
		PlayerMapData pmd = pd.getMapData(mapInternalName);
		Map map = MapManager.getMap(mapInternalName);
		
		ItemStack toReturn = map.getGuiItem().clone();
		
		List<String> loreToSet = new ArrayList<String>();
		
		// First line - Unlock status and price if not unlocked
		String firstLine;
		if (pmd.isUnlocked()) {
			// Unlocked 
			firstLine = Messager.color("&a&lUNLOCKED: Left click to start");
		} else {
			if (map.getPurchaseCost() <= pd.getCurrency()) {
				// Player can unlock this
				firstLine = Messager.color("&aRight click to UNLOCK for " + map.getPurchaseCost());
			} else {
				// Player cannot unlock this
				firstLine = Messager.color("&cRight click to UNLOCK for " + map.getPurchaseCost());
			}
		}
		// End First Line
		
		// Second Line - Finish reward
		String secondLine;
		
		int reward;
		if (pmd.getFinishes() == 0) {
			reward = map.getRewardAmount();
		} else {
			
			reward = (int) (map.getRewardAmount() - (pmd.getFinishes() *  (.25 * map.getRewardAmount())));
		}
		// End Second Line
		
		return null;
	}
	
}
