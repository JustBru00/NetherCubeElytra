package com.gmail.justbru00.nethercube.elytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.nethercube.elytra.gui.GUIManager;
import com.gmail.justbru00.nethercube.elytra.main.NetherCubeElytra;
import com.gmail.justbru00.nethercube.elytra.utils.Messager;

public class ElytraAdminCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("elytraadmin")) {
			
			if (!sender.hasPermission("nethercubeelytra.elytraadmin")) {
				Messager.msgSender("&cYou don't have a cool enough prefix to use this command.", sender);
				return true;
			}
			
			if (args.length == 0) {
				Messager.msgSender("&cUhh... you &omight &r&cneed to provide an argment after this command. Use /elytraadmin help for a list of arguments.", sender);
				return true;
			}
			
			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("help")) {
					// TODO FINISH HELP
				} else if (args[0].equals("bal")) {
					// TODO /elyadmin bal <set,get> <player> <amount>
				} else if (args[0].equalsIgnoreCase("maps")) {
					// TODO /elyadmin maps <list,tp> <mapname>(for tp)
				} else if (args[0].equalsIgnoreCase("testgui")) {
					Messager.msgSender("&aOpening the GUI.", sender);
					
					if (sender instanceof Player) {
						Player p = (Player) sender;
						GUIManager.openMainGUI(p);
						Messager.msgPlayer("&aGUI has been opened", p);
						return true;
					} 
					Messager.msgSender("&cUhhh... GUIs can only be opened by a player. You knew that right?", sender);
					return true;
				} else if (args[0].equalsIgnoreCase("reload")) {
					NetherCubeElytra.getInstance().reloadConfig();
					NetherCubeElytra.dataFile.reload();
					Messager.msgSender("&aReloaded config.yml and data.yml.", sender);
					return true;
				} else {
					Messager.msgSender("&cSorry that the argument " + args[0] + " is not correct. Use /elytraadmin help for a list of arguments.", sender);
					return true;
				}
			}
			
			return true;
		}
		
		return false;
	}

}
