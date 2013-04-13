package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class KillCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("kill")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println("[CommandBin] " + Phrases.get("invalid-arguments"));
					return true;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println("[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				
				player.setHealth(0);
				System.out.println("[CommandBin] " + Phrases.get("kill-player"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.kill.self")) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
					return true;
				}
				
				player.setHealth(0);
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("kill-self"));
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.kill.others")) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
					return true;
				}
				
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				
				otherPlayer.setHealth(0);
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("kill-player"));
				return true;
			}
			
			player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
