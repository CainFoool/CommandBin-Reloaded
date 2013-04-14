package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class StarveCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("starve")) {
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
				
				player.setFoodLevel(0);
				System.out.println(Phrases.get("starve-others"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(player.hasPermission("CommandBin.starve.self")) {
					player.setFoodLevel(0);
					player.sendMessage(Phrases.get("starve-self"));
					return true;
				}
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length == 1) {
				if(player.hasPermission("CommandBin.starve.others")) {
					Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
					if(otherPlayer == null) {
						player.sendMessage(Phrases.get("player-invalid"));
						return true;
					}
					otherPlayer.setFoodLevel(0);
					player.sendMessage(Phrases.get("starve-others"));
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
