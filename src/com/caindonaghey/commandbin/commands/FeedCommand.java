package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class FeedCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("feed")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				
				player.setFoodLevel(20);
				System.out.println(Phrases.get("fed-other"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(player.hasPermission("CommandBin.feed.self")) {
					player.setFoodLevel(20);
					player.sendMessage(Phrases.get("fed-self"));
					return true;
				}
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length == 1) {
				if(player.hasPermission("CommandBin.feed.others")) {
					Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
					if(otherPlayer == null) {
						player.sendMessage(Phrases.get("player-invalid"));
						return true;
					}
					otherPlayer.setFoodLevel(20);
					player.sendMessage(Phrases.get("fed-other"));
					return true;
				}
				player.sendMessage(Phrases.get("no-permission"));
			return true;
			}
			
			player.sendMessage(Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
