package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class VanishCommand implements CommandExecutor {
	
	public static HashSet<String> vanishedPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("vanish")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return true;
				}
				
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				
				if(!vanishedPlayers.contains(otherPlayer.getName())) {
					vanishedPlayers.add(otherPlayer.getName());
					for(Player allPlayers : Bukkit.getServer().getOnlinePlayers()) {
						if(allPlayers.getName() != otherPlayer.getName() && !allPlayers.isOp()) {
							allPlayers.hidePlayer(otherPlayer);
						}
					}
					System.out.println(Phrases.get("player-vanish"));
					return true;
				}
				vanishedPlayers.remove(otherPlayer.getName());
				for(Player allPlayers : Bukkit.getServer().getOnlinePlayers()) {
					if(allPlayers.getName() != otherPlayer.getName() && !allPlayers.isOp()) {
						allPlayers.showPlayer(otherPlayer);
					}
				}
				System.out.println(Phrases.get("player-visible"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.vanish.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				
				if(!vanishedPlayers.contains(player.getName())) {
					vanishedPlayers.add(player.getName());
					for(Player allPlayers : Bukkit.getServer().getOnlinePlayers()) {
						if(allPlayers.getName() != player.getName() && !allPlayers.isOp()) {
							allPlayers.hidePlayer(player);
						}
					}
					player.sendMessage(Phrases.get("self-invisible"));
					return true;
				}
				vanishedPlayers.remove(player.getName());
				for(Player allPlayers : Bukkit.getServer().getOnlinePlayers()) {
					if(allPlayers.getName() != player.getName() && !allPlayers.isOp()) {
						allPlayers.showPlayer(player);
					}
				}
				player.sendMessage(Phrases.get("self-visible"));
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.vanish.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				
				if(!vanishedPlayers.contains(otherPlayer.getName())) {
					vanishedPlayers.add(otherPlayer.getName());
					for(Player allPlayers : Bukkit.getServer().getOnlinePlayers()) {
						if(allPlayers.getName() != otherPlayer.getName() && !allPlayers.isOp()) {
							allPlayers.hidePlayer(otherPlayer);
						}
					}
					player.sendMessage(Phrases.get("player-vanish"));
					return true;
				}
				vanishedPlayers.remove(otherPlayer.getName());
				for(Player allPlayers : Bukkit.getServer().getOnlinePlayers()) {
					if(allPlayers.getName() != otherPlayer.getName() && !allPlayers.isOp()) {
						allPlayers.showPlayer(otherPlayer);
					}
				}
				player.sendMessage(Phrases.get("player-visible"));
			}
		}
		return true;
	}

}
