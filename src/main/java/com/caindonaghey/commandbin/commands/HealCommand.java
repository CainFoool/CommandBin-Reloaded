package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class HealCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("heal")) {
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
				
				player.setHealth(20);
				System.out.println(Phrases.get("heal-other"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(player.hasPermission("CommandBin.heal.self")) {
					player.setHealth(player.getMaxHealth());
					player.sendMessage(Phrases.get("heal-self"));
					return true;
				}
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length == 1) {
				if(player.hasPermission("CommandBin.heal.others")) {
					Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
					if(otherPlayer == null) {
						player.sendMessage(Phrases.get("player-invalid"));
						return true;
					}
					otherPlayer.setHealth(otherPlayer.getMaxHealth());
					player.sendMessage(Phrases.get("heal-other"));
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
