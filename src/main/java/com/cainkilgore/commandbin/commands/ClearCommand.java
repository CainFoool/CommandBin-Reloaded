package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class ClearCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("clear")) {
			if(!(s instanceof Player)) {
				if(args.length < 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				
				if(player == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				
				player.getInventory().clear();
				player.getInventory().setArmorContents(null);
				System.out.println(Phrases.get("inventory-cleared"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				if(player.hasPermission("CommandBin.clear.self")) {
					player.getInventory().clear();
					player.getInventory().setArmorContents(null);
					player.sendMessage(Phrases.get("inventory-cleared"));
					return true;
				}
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length == 1) {
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(player.hasPermission("CommandBin.clear.others")) {
					if(otherPlayer == null) {
						player.sendMessage(Phrases.get("player-invalid"));
						return true;
					}
					otherPlayer.getInventory().clear();
					otherPlayer.getInventory().setArmorContents(null);
					player.sendMessage(Phrases.get("inventory-cleared"));
					return true;
				}
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			player.sendMessage(Phrases.get("invalid-arguments"));
		}
		return true;
	}

}
