package com.caindonaghey.commandbin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Home;
import com.caindonaghey.commandbin.Phrases;

public class HomeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("home")) {
			if(!(s instanceof Player)) {
				System.out.println("[CommandBin] " + Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			if(!player.hasPermission("CommandBin.home")) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
				return true;
			}
			if(Home.ifHasHome(player)) {
				player.teleport(Home.getHome(player));
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("home-teleport"));
				return true;
			}
			player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-home"));
		}
		return true;
	}

}
