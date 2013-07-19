package com.cainkilgore.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class SmokeCommand implements CommandExecutor {
	
	public static HashSet<String> smokePlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("smoke")) {
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
				if(!smokePlayers.contains(player.getName())) {
					smokePlayers.add(player.getName());
					System.out.println(Phrases.get("player-smoke-on"));
					return true;
				}
				smokePlayers.remove(player.getName());
				System.out.println(Phrases.get("player-smoke-off"));
				return true;
			}
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.smoke.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				if(!smokePlayers.contains(player.getName())) {
					smokePlayers.add(player.getName());
					player.sendMessage(Phrases.get("self-smoke-on"));
					return true;
				}
				smokePlayers.remove(player.getName());
				player.sendMessage(Phrases.get("self-smoke-off"));
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.smoke.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				if(!smokePlayers.contains(otherPlayer.getName())) {
					smokePlayers.add(otherPlayer.getName());
					player.sendMessage(Phrases.get("player-smoke-on"));
					return true;
				}
				smokePlayers.remove(otherPlayer.getName());
				player.sendMessage(Phrases.get("player-smoke-off"));
			}
			
			player.sendMessage(Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
