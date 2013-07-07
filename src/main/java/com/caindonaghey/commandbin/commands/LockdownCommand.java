package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class LockdownCommand implements CommandExecutor {
	
	public static boolean serverLockdown = false;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("lockdown")) {
			if(!(s instanceof Player)) {
				if(serverLockdown) {
					serverLockdown = false;
					Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Lockdown mode has been disabled.");
					return true;
				}
				serverLockdown = true;
				Bukkit.getServer().broadcastMessage(ChatColor.RED + "Lockdown mode has been activated.");
				Bukkit.getServer().broadcastMessage(ChatColor.RED + "Nobody can place/talk unless exempt by permissions.");
				return true;
			}
			
			Player player = (Player) s;
			if(!player.hasPermission("CommandBin.lockdown")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(serverLockdown) {
				serverLockdown = false;
				Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Lockdown mode has been disabled.");
				return true;
			}
			serverLockdown = true;
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "Lockdown mode has been activated.");
			Bukkit.getServer().broadcastMessage(ChatColor.RED + "Nobody can place/talk unless exempt by permissions.");
		}
		return true;
	}

}
