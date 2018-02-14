package com.gmail.justbru00.nethercube.elytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
