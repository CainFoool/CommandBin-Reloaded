package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class BroadcastCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("broadcast")) {
			if(!(s instanceof Player)) {
				if(args.length < 1) {
					System.out.println("[CommandBin] " + Phrases.get("invalid-arguments"));
					return false;
				}
				
				StringBuilder x = new StringBuilder();
				for(int i = 0; i < args.length; i++) {
					x.append(args[i] + " ");
				}
				
				Bukkit.getServer().broadcastMessage(ChatColor.GOLD + x.toString().trim());
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.broadcast")) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
				return false;
			}
			
			StringBuilder x = new StringBuilder();
			for(int i = 0; i < args.length; i++) {
				x.append(args[i] + " ");
			}
			
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + x.toString().trim());
		}
		return true;
	}

}
