package com.gmail.justbru00.nethercube.elytra.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.nethercube.elytra.utils.ItemBuilder;

public class HotbarGUIManager {
	// Chapter back inactive
	// /give @p skull 1 3 {display:{Name:"Chapter Back"},SkullOwner:{Id:"9d008ae1-9bfa-4d9c-a05d-46d4d9c9db4e",Properties:{textures:[{Value:"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGZlNjY4ZTBkMzE0MTk3OGI4YWUyN2JmMjExYjAxYjQ0ZjEwNmI5ZDY0NzQxN2I4NTIwYTBhZGJjZjJlZjM1ZiJ9fX0="}]}}}
	
	
	// Chapter back active
	// /give @p skull 1 3 {display:{Name:"Chapter Back (active)"},SkullOwner:{Id:"1835860f-4273-4093-8444-fd1549e02b34",Properties:{textures:[{Value:"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE1M2QwNDc5N2I0N2E2ODQ4NGQxMTEwMjVkOTQwYTM0ODg2YTBmYThkYzgwNmU3NDU3MDI0YTg3ZjFhYmQ1NiJ9fX0="}]}}}
	
	
	private static ItemStack gamemodeSelectorHotbarItem;
	private static ItemStack cosmeticsSelectorHotbarItem;
	private static ItemStack optionsSelectorHotbarItem;
	private static ItemStack fourmsSelectorHotbarItem;
	private static ItemStack discordSelectorHotbarItem;
	private static ItemStack donorRanksStoreSelectorItem;
	
	
	/**
	 * Get the items ready.
	 */
	public static void init() {
		
		gamemodeSelectorHotbarItem = new ItemBuilder(Material.END_CRYSTAL).setName("&bGamemode Selector &7[Right Click]").build();
		cosmeticsSelectorHotbarItem = new ItemBuilder(Material.CHORUS_FRUIT_POPPED).setName("&fCosmetics &7[Right Click]").build();
		optionsSelectorHotbarItem = new ItemBuilder(Material.REDSTONE_COMPARATOR).setName("&fOptions &7[Right Click]").build();
		
		
		
	}

	public static void setLobbyItems(Player p) {
		
	}
	
	public static void setElytraCourseItems(Player p) {
		
	}
	
	public static void setParkourCourseItems(Player p) {
		// TODO HOOK INTO PARKOUR
	}
	
	
	
}
