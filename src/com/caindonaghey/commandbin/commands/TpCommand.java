package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class TpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("tp")) {
			if(!(s instanceof Player)) {
				if(args.length < 2 || args.length == 3) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				if(args.length == 2) {
					Player onePlayer = Bukkit.getServer().getPlayer(args[0]);
					Player twoPlayer = Bukkit.getServer().getPlayer(args[1]);
					if(onePlayer == null || twoPlayer == null) {
						System.out.println(Phrases.get("players-invalid"));
						return true;
					}
					onePlayer.teleport(twoPlayer.getLocation());
					System.out.println(Phrases.get("tele-1-2"));
					onePlayer.sendMessage(Phrases.get("console-tp-1").replace("{PLAYER}", twoPlayer.getName()));
					twoPlayer.sendMessage(Phrases.get("console-tp-2").replace("{PLAYER}", onePlayer.getName()));
					return true;
				}
				
				if(args.length == 4) {
					Player player = Bukkit.getServer().getPlayer(args[0]);
					if(player == null) {
						System.out.println(Phrases.get("player-invalid"));
						return true;
					}
					
					try {
						int x = Integer.parseInt(args[1]);
						int y = Integer.parseInt(args[2]);
						int z = Integer.parseInt(args[3]);
						player.teleport(new Location(player.getWorld(), x, y, z));
						System.out.println(Phrases.get("tele-1-co"));
						player.sendMessage(Phrases.get("console-tp-coord").replace("{X}", x + "").replace("{Y}", y + "").replace("{Z}", z + ""));
					} catch (NumberFormatException e) {
						System.out.println(Phrases.get("invalid-numbers"));
					}
					return true;
				}
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.tp.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				player.teleport(otherPlayer.getLocation());
				otherPlayer.sendMessage(Phrases.get("player-tped").replace("{PLAYER}", player.getName()));
				player.sendMessage(Phrases.get("tele-player"));
				return true;
			}
			
			if(args.length == 2) {
				if(!player.hasPermission("CommandBin.tp.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				
				Player onePlayer = Bukkit.getServer().getPlayer(args[0]);
				Player twoPlayer = Bukkit.getServer().getPlayer(args[1]);
				
				if(onePlayer == null || twoPlayer == null) {
					player.sendMessage(Phrases.get("players-invalid"));
					return true;
				}
				onePlayer.teleport(twoPlayer.getLocation());
				onePlayer.sendMessage(Phrases.get("player-tp-1").replace("{PLAYER}", player.getName()).replace("{PLAYER2}", twoPlayer.getName()));
				player.sendMessage(Phrases.get("tele-1-2"));
				twoPlayer.sendMessage(Phrases.get("player-tp-2").replace("{PLAYER}", player.getName()).replace("{PLAYER2}", onePlayer.getName()));
				return true;
			}
			
			if(args.length == 3) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args.length == 4) {
				
				if(!player.hasPermission("CommandBin.tp.coords")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				
				try {
					int x = Integer.parseInt(args[1]);
					int y = Integer.parseInt(args[2]);
					int z = Integer.parseInt(args[3]);
					otherPlayer.teleport(new Location(otherPlayer.getWorld(), x, y, z));
					otherPlayer.sendMessage(Phrases.get("player-tp-coord").replace("{PLAYER}", player.getName()).replace("{X}", x + "").replace("{Y}", y + "").replace("{Z}", z + ""));
					player.sendMessage(Phrases.get("tele-1-co"));
				} catch (NumberFormatException e) {
					player.sendMessage(Phrases.get("invalid-numbers"));
				}
				return true;
			}
		}
		return true;
	}

}
