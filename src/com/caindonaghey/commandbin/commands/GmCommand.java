package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class GmCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("gm")) {
			if(!(s instanceof Player)) {
				if(args.length < 2) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				
				if(player == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				
				if(args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("survival")) {
					player.setGameMode(GameMode.SURVIVAL);
					System.out.println(Phrases.get("gamemode-switch"));
					return true;
				}
				
				if(args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("c") || args[1].equalsIgnoreCase("creative")) {
					player.setGameMode(GameMode.CREATIVE);
					System.out.println(Phrases.get("gamemode-switch"));
					return true;
				}
				
				if(args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("a") || args[1].equalsIgnoreCase("adventure")) {
					player.setGameMode(GameMode.ADVENTURE);
					System.out.println(Phrases.get("gamemode-switch"));
					return true;
				}
				
				System.out.println(Phrases.get("invalid-gamemode"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 1) {
				if(player.hasPermission("CommandBin.gamemode.survival")) {
					if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival")) {
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(Phrases.get("gamemode-switch"));
						return true;
					}
				}
				
				if(player.hasPermission("CommandBin.gamemode.creative")) {
					if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative")) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage(Phrases.get("gamemode-switch"));
						return true;
					}
				}
				
				if(player.hasPermission("CommandBin.gamemode.adventure")) {
					if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure")) {
						player.setGameMode(GameMode.ADVENTURE);
						player.sendMessage(Phrases.get("gamemode-switch"));
						return true;
					}
				}
				
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			//
			if(args.length == 2) {
				
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				
				if(player.hasPermission("CommandBin.gamemode.others.survival")) {
					if(args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("survival")) {
						otherPlayer.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(Phrases.get("gamemode-switch"));
						return true;
					}
				}
				
				if(player.hasPermission("CommandBin.gamemode.others.creative")) {
					if(args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("c") || args[1].equalsIgnoreCase("creative")) {
						otherPlayer.setGameMode(GameMode.CREATIVE);
						player.sendMessage(Phrases.get("gamemode-switch"));
						return true;
					}
				}
				
				if(player.hasPermission("CommandBin.gamemode.others.adventure")) {
					if(args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("a") || args[1].equalsIgnoreCase("adventure")) {
						otherPlayer.setGameMode(GameMode.ADVENTURE);
						player.sendMessage(Phrases.get("gamemode-switch"));
						return true;
					}
				}
				
			player.sendMessage(Phrases.get("invalid-gamemode"));
			return false;
			}
			
			player.sendMessage(Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
