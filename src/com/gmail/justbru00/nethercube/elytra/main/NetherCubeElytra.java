package com.gmail.justbru00.nethercube.elytra.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.nethercube.elytra.commands.ElytraAdminCommand;
import com.gmail.justbru00.nethercube.elytra.commands.ElytraCommand;
import com.gmail.justbru00.nethercube.elytra.gui.GUIManager;
import com.gmail.justbru00.nethercube.elytra.listeners.ConfirmGUIListener;
import com.gmail.justbru00.nethercube.elytra.listeners.MainGUIListener;
import com.gmail.justbru00.nethercube.elytra.map.MapManager;
import com.gmail.justbru00.nethercube.elytra.utils.Messager;
import com.gmail.justbru00.nethercube.elytra.utils.PluginFile;

public class NetherCubeElytra extends JavaPlugin {
	
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();
	public static Logger log = Bukkit.getLogger();
	public static String prefix = Messager.color("&8[&cNether&6Cube&fElytra&8] &6");
	private static  NetherCubeElytra instance;
	public static PluginFile dataFile = null;
	public static boolean debug = true;

	@Override
	public void onDisable() {
		Messager.msgConsole("&cThe plugin is disabled.");
		instance = null;
	}

	@Override
	public void onEnable() {
		instance = this;
		
		Messager.msgConsole("&aEnabling plugin...");
		
		// INIT STUFF
		saveDefaultConfig();
		MapManager.init();
		dataFile = new PluginFile(this, "data.yml", "data.yml");		
		GUIManager.init();
		
		// REGISTER COMMANDS
		getCommand("elytra").setExecutor(new ElytraCommand());
		getCommand("elytraadmin").setExecutor(new ElytraAdminCommand());
		// TODO /elytrabalance
		
		// REGISTER LISTENERS
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new MainGUIListener(), instance);
		pm.registerEvents(new ConfirmGUIListener(), instance);
		
	}
	
	public static NetherCubeElytra getInstance() {
		return instance;
	}

}
