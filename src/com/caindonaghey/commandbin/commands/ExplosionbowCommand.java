package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class ExplosionbowCommand implements CommandExecutor {
	
	public static HashSet<String> explosionBowPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("explosionbow")) {
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
				
				if(!explosionBowPlayers.contains(player.getName())) {
					explosionBowPlayers.add(player.getName());
					System.out.println("[CommandBin] " + Phrases.get("player-bow"));
					return true;
				}
				explosionBowPlayers.remove(player.getName());
				System.out.println("[CommandBin]" + Phrases.get("player-nobow"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.explosionbow.self")) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
					return true;
				}
				if(!explosionBowPlayers.contains(player.getName())) {
					explosionBowPlayers.add(player.getName());
					player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("self-bow"));
					return true;
				}
				explosionBowPlayers.remove(player.getName());
				player.sendMessage(ChatColor.GREEN + "[CommandBin]" + Phrases.get("self-nobow"));
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.explosionbow.others")) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				if(!explosionBowPlayers.contains(otherPlayer.getName())) {
					explosionBowPlayers.add(otherPlayer.getName());
					player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("player-bow"));
					return true;
				}
				explosionBowPlayers.remove(otherPlayer.getName());
				player.sendMessage(ChatColor.GREEN + "[CommandBin]" + Phrases.get("player-nobow"));
				return true;
			}
			player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
