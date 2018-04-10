package com.gmail.justbru00.nethercube.elytra.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.nethercube.elytra.data.PlayerData;
import com.gmail.justbru00.nethercube.elytra.gui.GUIManager;
import com.gmail.justbru00.nethercube.elytra.main.NetherCubeElytra;
import com.gmail.justbru00.nethercube.elytra.map.MapManager;
import com.gmail.justbru00.nethercube.elytra.timer.PlayerTimer;
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
					Messager.msgSender("&6/elytraadmin currency <set,get,add,subtract> <playerName,UUID> (amount)", sender);
					Messager.msgSender("&6/elytraadmin maps <list,tp> (player)", sender);
					Messager.msgSender("&6/elytraadmin reload", sender);
					return true;
				} else if (args[0].equals("currency") || args[0].equalsIgnoreCase("cur")) {
					// TODO /elyadmin currency <set,get,add,remove> <player> <amount>	
					
					if (args.length >= 3) {
					
					OfflinePlayer offline = null;
					
					if (args[2].length() > 16) { // Is UUID Maybe?
						UUID id = null;
						try {
							id = UUID.fromString(args[2]);
						} catch (IllegalArgumentException e) {
							Messager.msgSender("&cUhh... " + args[2] + " doesn't appear to be properly formatted UUID string. Fix that please. It really helps my sanity.", sender);
							return true;
						}
						
						try {
							offline = Bukkit.getOfflinePlayer(id);
						} catch (Exception e) {
							return true;
						}
					} else {
						try {
							offline = Bukkit.getPlayer(args[2]);
						} catch (Exception e) {
							Messager.msgSender("&cCannot find player with the username " + args[2] + " online. If the player is offline, please provide their UUID instead.", sender);
							return true;
						}
						
						if (offline == null) {
							Messager.msgSender("&cCannot find player with the username " + args[2] + " online. If the player is offline, please provide their UUID instead.", sender);
							return true;
						}
					}
					
					PlayerData pd = PlayerData.getDataFor(offline);
					
					if (args[1].equalsIgnoreCase("get")) {
						if (offline.getName() == null) {
							Messager.msgSender("&a" + offline.getUniqueId().toString() + " has " + pd.getCurrency() + " currency.", sender);
						} else {
							Messager.msgSender("&a" + offline.getName() + " has " + pd.getCurrency() + " currency.", sender);
						}
						
						return true;
					}
					
					int amount = 0;
					
					try {
						amount = Integer.parseInt(args[3]);
					} catch (NumberFormatException e) {
						Messager.msgSender("&cThe value '" + args[3] + "' cannot be parsed as an Integer. Make sure is is a number without a decimal point.", sender);
						return true;
					}
					
					if (args[1].equalsIgnoreCase("set")) {
						pd.setCurrency(amount).save();
						if (offline.getName() == null) {
							Messager.msgSender("&aSet " + offline.getUniqueId().toString() + "'s currency balance to " + amount + ".", sender);
						} else {
							Messager.msgSender("&aSet " + offline.getName() + "'s currency balance to " + amount + ".", sender);
						}
						return true;
					} else if (args[1].equalsIgnoreCase("add")) {
						pd.setCurrency(pd.getCurrency() + amount).save();
						if (offline.getName() == null) {
							Messager.msgSender("&aAdded " + amount + " to " + offline.getUniqueId().toString() + "'s balance. They now have a total of " + pd.getCurrency() + ".", sender);
						} else {
							Messager.msgSender("&aAdded " + amount + " to " + offline.getName() + "'s balance. They now have a total of " + pd.getCurrency() + ".", sender);
						}
						return true;
					} else if (args[1].equalsIgnoreCase("subtract")) {
						if (pd.getCurrency() - amount < 0) {
							pd.setCurrency(0).save();
							if (offline.getName() == null) {
								Messager.msgSender("&aSubtracted " + amount + " from " + offline.getUniqueId().toString() + "'s balance. They now have a total of " + pd.getCurrency() + ".", sender);
							} else {
								Messager.msgSender("&aSubtracted " + amount + " from " + offline.getName() + "'s balance. They now have a total of " + pd.getCurrency() + ".", sender);
							}
						} else {
							pd.setCurrency(pd.getCurrency() - amount).save();
							if (offline.getName() == null) {
								Messager.msgSender("&aSubtracted " + amount + " from " + offline.getUniqueId().toString() + "'s balance. They now have a total of " + pd.getCurrency() + ".", sender);
							} else {
								Messager.msgSender("&aSubtracted " + amount + " from " + offline.getName() + "'s balance. They now have a total of " + pd.getCurrency() + ".", sender);
							}
						}
						return true;
					} else {
						Messager.msgSender("&cPlease provide the correct arguments. /elytraadmin currency <set,get,add,subtract> <player,UUID> (amount)", sender);
						return true;
					}
					
					} else {
						Messager.msgSender("&cPlease provide the correct arguments. /elytraadmin currency <set,get,add,subtract> <player,UUID> (amount)", sender);
						return true;
					}
						
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
					MapManager.init();
					GUIManager.init();
					PlayerTimer.init();
					Messager.msgSender("&aReinitialized MapManager, GUIManager, and PlayerTimer.", sender);
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
