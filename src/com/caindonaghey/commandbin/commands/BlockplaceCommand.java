package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class BlockplaceCommand implements CommandExecutor {
	
	public static HashSet<String> placePlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("blockplace")) {
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
				
				if(!placePlayers.contains(player.getName())) {
					placePlayers.add(player.getName());
					player.sendMessage(Phrases.get("self-blocks"));
					System.out.println(Phrases.get("player-blocks"));
					return true;
				}
				placePlayers.remove(player.getName());
				System.out.println(Phrases.get("player-blocks-off"));
				player.sendMessage(Phrases.get("self-blocks-off"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.blockplace")) {
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
			
			if(!placePlayers.contains(otherPlayer.getName())) {
				placePlayers.add(otherPlayer.getName());
				player.sendMessage(Phrases.get("self-blocks"));
				otherPlayer.sendMessage(Phrases.get("player-blocks"));
				return true;
			}
			placePlayers.remove(otherPlayer.getName());
			otherPlayer.sendMessage(Phrases.get("player-blocks-off"));
			player.sendMessage(Phrases.get("self-blocks-off"));
		}
		return true;
	}

}
