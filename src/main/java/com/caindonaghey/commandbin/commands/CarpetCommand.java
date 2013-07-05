package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class CarpetCommand implements CommandExecutor {
	
	public static HashSet<String> carpetPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("carpet")) {
			if(!(s instanceof Player)) {
			System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			if(!player.hasPermission("CommandBin.carpet")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(!carpetPlayers.contains(player.getName())) {
				carpetPlayers.add(player.getName());
				player.sendMessage(Phrases.get("carpet-on"));
				return true;
			}
			carpetPlayers.remove(player.getName());
			player.sendMessage(Phrases.get("carpet-off"));
		}
		return true;
	}

}
