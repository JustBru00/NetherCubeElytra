package com.gmail.justbru00.nethercube.elytra.gui;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.nethercube.elytra.utils.ItemBuilder;

public class HotbarGUI {
	// Chapter back inactive
	// /give @p skull 1 3 {display:{Name:"Chapter Back"},SkullOwner:{Id:"9d008ae1-9bfa-4d9c-a05d-46d4d9c9db4e",Properties:{textures:[{Value:"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGZlNjY4ZTBkMzE0MTk3OGI4YWUyN2JmMjExYjAxYjQ0ZjEwNmI5ZDY0NzQxN2I4NTIwYTBhZGJjZjJlZjM1ZiJ9fX0="}]}}}
	
	
	// Chapter back active
	// /give @p skull 1 3 {display:{Name:"Chapter Back (active)"},SkullOwner:{Id:"1835860f-4273-4093-8444-fd1549e02b34",Properties:{textures:[{Value:"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE1M2QwNDc5N2I0N2E2ODQ4NGQxMTEwMjVkOTQwYTM0ODg2YTBmYThkYzgwNmU3NDU3MDI0YTg3ZjFhYmQ1NiJ9fX0="}]}}}
	private static ItemStack elytra;
	private static ItemStack restartCurrentMapItem;
	private static ItemStack restartCurrentMapClickedItem;
	private static ItemStack exitToElytraLobbyItem;
	private static ItemStack hidePlayersItem;
	private static ItemStack showPlayersItem;
	
	public static void init() {
		
		ItemStack toBeElytra = new ItemBuilder(Material.ELYTRA).setName("&bElytra").setUnbreakable(true).build();
		toBeElytra.addEnchantment(Enchantment.BINDING_CURSE, 1);
		
		elytra = toBeElytra;
		
		exitToElytraLobbyItem = new ItemBuilder(Material.NETHER_STAR).setName("&cExit to lobby &7[Right Click]").build();
		hidePlayersItem = new ItemBuilder(Material.EYE_OF_ENDER).setName("&cHide Players &7[Right Click]").build();
		showPlayersItem = new ItemBuilder(Material.ENDER_PEARL).setName("&aShow Players &7[Right Click]").build();
		
		
		
	}

	/**
	 * Sets the correct items in the players inventory.
	 * @param p
	 */
	public static void setInventory(Player p) {
		
	}
	
}
