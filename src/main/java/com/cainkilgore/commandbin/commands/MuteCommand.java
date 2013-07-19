package com.cainkilgore.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class MuteCommand implements CommandExecutor {
	
	public static HashSet<String> mutedPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("mute")) {
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
				
				if(!mutedPlayers.contains(player.getName())) {
					mutedPlayers.add(player.getName());
					System.out.println(Phrases.get("player-muted"));
					player.sendMessage(Phrases.get("player-muted").replace("Player", "You").replace("They", "You").replace("has", "have"));
					return true;
				}
				mutedPlayers.remove(player.getName());
				player.sendMessage(Phrases.get("player-unmuted").replace("Player", "You").replace("They", "You").replace("has", "have"));
				System.out.println(Phrases.get("player-unmuted"));
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
				otherPlayer.sendMessage(Phrases.get("player-muted").replace("Player", "You").replace("They", "You").replace("has", "have"));
				return true;
			}
			mutedPlayers.remove(otherPlayer.getName());
			otherPlayer.sendMessage(Phrases.get("player-muted").replace("Player", "You").replace("They", "You").replace("has", "have"));
			player.sendMessage(Phrases.get("player-unmuted"));
			return true;
		}
		return true;
	}

}
