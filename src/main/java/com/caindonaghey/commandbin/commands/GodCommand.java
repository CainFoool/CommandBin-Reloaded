package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class GodCommand implements CommandExecutor {
	
	public static HashSet<String> godPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("god")) {
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
				
				if(!godPlayers.contains(player.getName())) {
					godPlayers.add(player.getName());
					System.out.println(Phrases.get("player-godmode"));
					return true;
				}
				System.out.println(Phrases.get("player-ungod"));
				godPlayers.remove(player.getName());
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.god.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				if(!godPlayers.contains(player.getName())) {
					godPlayers.add(player.getName());
					player.sendMessage(Phrases.get("god-enabled"));
					return true;
				}
				godPlayers.remove(player.getName());
				player.sendMessage(Phrases.get("god-disabled"));
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.god.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				
				if(!godPlayers.contains(otherPlayer.getName())) {
					godPlayers.add(otherPlayer.getName());
					player.sendMessage(Phrases.get("player-godmode"));
					return true;
				}
				godPlayers.remove(otherPlayer.getName());
				player.sendMessage(Phrases.get("player-ungod"));
				return true;
			}
			
			if(args.length >= 2) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
		}
		return true;
	}

}
