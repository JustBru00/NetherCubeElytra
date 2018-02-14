package com.gmail.justbru00.nethercube.elytra.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.nethercube.elytra.map.MapManager;
import com.gmail.justbru00.nethercube.elytra.utils.Messager;

public class NetherCubeElytra extends JavaPlugin {
	
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();
	public static Logger log = Bukkit.getLogger();
	public static String prefix = Messager.color("&8[&cNether&6Cube&fElytra&8] &6");
	private static  NetherCubeElytra instance;

	@Override
	public void onDisable() {
		
		instance = null;
	}

	@Override
	public void onEnable() {
		instance = this;
		
		Messager.msgConsole("&aEnabling plugin...");
		
		// INIT STUFF
		MapManager.init();
		
		// REGISTER COMMANDS
		
		// REGISTER LISTENERS
	
	}
	
	public static NetherCubeElytra getInstance() {
		return instance;
	}

}
