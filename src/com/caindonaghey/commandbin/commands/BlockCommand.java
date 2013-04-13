package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class BlockCommand implements CommandExecutor {
	
	public static HashSet<String> blockedPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("block")) {
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
				
				if(!blockedPlayers.contains(player.getName())) {
					blockedPlayers.add(player.getName());
					System.out.println("[CommandBin] " + Phrases.get("player-blocked"));
					return true;
				}
				
				blockedPlayers.remove(player.getName());
				System.out.println("[CommandBin] " + Phrases.get("player-unblocked"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.block")) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
				return true;
			}
			
			Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
			
			if(otherPlayer == null) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("player-invalid"));
				return true;
			}
			
			if(!blockedPlayers.contains(otherPlayer.getName())) {
				blockedPlayers.add(otherPlayer.getName());
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("player-blocked"));
				return true;
			}
			
			blockedPlayers.remove(otherPlayer.getName());
			player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("player-unblocked"));
		}
		return true;
	}

}
