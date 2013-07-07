package com.caindonaghey.commandbin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Lockdown {
	
	
	// Should I even?
	
	public void lockdownCheck() {
		for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
			if(!onlinePlayers.hasPermission("CommandBin.lockdownexempt")) {
				onlinePlayers.kickPlayer(ChatColor.RED + "This server has gone into lockdown mode.");
			}
		}
	}

}
