package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class FreezeCommand implements CommandExecutor {
	
	public static HashSet<String> frozenPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("freeze")) {
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
				if(!frozenPlayers.contains(player.getName())) {
					frozenPlayers.add(player.getName());
					System.out.println("[CommandBin] " + Phrases.get("frozen-player"));
					return true;
				}
				frozenPlayers.remove(player.getName());
				System.out.println("[CommandBin] " + Phrases.get("unfrozen-player"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.freeze")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
			if(otherPlayer == null) {
				player.sendMessage(Phrases.get("player-invalid"));
				return true;
			}
			
			if(!frozenPlayers.contains(otherPlayer.getName())) {
				frozenPlayers.add(otherPlayer.getName());
				player.sendMessage(Phrases.get("frozen-player"));
				return true;
			}
			
			frozenPlayers.remove(otherPlayer.getName());
			player.sendMessage(Phrases.get("unfrozen-player"));
			return true;
		}
		return true;
	}

}
