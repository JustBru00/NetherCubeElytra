package com.gmail.justbru00.nethercube.elytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.justbru00.nethercube.elytra.utils.Messager;

public class ElytraCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("elytra")) {
			if (!sender.hasPermission("nethercubeelytra.elytra")) {
				Messager.msgSender("&cSorry you don't have permission to use that command.", sender);
				return true;
			}
			
			// TODO OPEN GUI
			
			
			return true;
		}
		
		return false;
	}
	
}
