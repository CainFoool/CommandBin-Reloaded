package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class SpawnCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("spawn")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println("[CommandBin] " + Phrases.get("invalid-arguments"));
					return false;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println("[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				
				player.teleport(player.getWorld().getSpawnLocation());
				System.out.println("[CommandBin] " + Phrases.get("spawn-player"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.spawn.self")) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
					return true;
				}
				player.teleport(player.getWorld().getSpawnLocation());
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("player-tele-spawn"));
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.spawn.others")) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				otherPlayer.teleport(otherPlayer.getWorld().getSpawnLocation());
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("spawn-player"));
			}
			
			if(args.length > 1) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
				return false;
			}
		}
		return true;
	}

}
