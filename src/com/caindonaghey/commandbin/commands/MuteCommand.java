package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class MuteCommand implements CommandExecutor {
	
	public static HashSet<String> mutedPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("mute")) {
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
				
				if(!mutedPlayers.contains(player.getName())) {
					mutedPlayers.add(player.getName());
					System.out.println("[CommandBin] " + Phrases.get("player-muted"));
					return true;
				}
				mutedPlayers.remove(player.getName());
				System.out.println("[CommandBin] " + Phrases.get("player-unmuted"));
				return true;
			}
			
			Player player = (Player) s;
			
			
			if(!player.hasPermission("CommandBin.mute")) {
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
			
			if(!mutedPlayers.contains(otherPlayer.getName())) {
				mutedPlayers.add(otherPlayer.getName());
				player.sendMessage(Phrases.get("player-muted"));
				return true;
			}
			mutedPlayers.remove(otherPlayer.getName());
			player.sendMessage(Phrases.get("player-unmuted"));
			return true;
		}
		return true;
	}

}
