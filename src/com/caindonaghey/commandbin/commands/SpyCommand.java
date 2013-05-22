package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class SpyCommand implements CommandExecutor {
	
	public static HashSet<String> spyPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("spy")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.spy")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 0) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(!spyPlayers.contains(player.getName())) {
				spyPlayers.add(player.getName());
				player.sendMessage(Phrases.get("spy-on"));
				return true;
			}
			spyPlayers.remove(player.getName());
			player.sendMessage(Phrases.get("spy-off"));
		}
		return true;
	}

}
