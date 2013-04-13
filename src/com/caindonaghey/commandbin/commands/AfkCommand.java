package com.caindonaghey.commandbin.commands;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class AfkCommand implements CommandExecutor {
	
	public static HashSet<String> AFKPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("afk")) {
			if(!(s instanceof Player)) {
				System.out.println("[CommandBin] " + Phrases.get("no-console"));
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.afk")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 0) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return true;
			}
			
			if(!AFKPlayers.contains(player.getName())) {
				AFKPlayers.add(player.getName());
				player.sendMessage(Phrases.get("now-afk"));
				return true;
			}
			
			AFKPlayers.remove(player.getName());
			player.sendMessage(Phrases.get("no-afk"));
			
		}
		return true;
	}

}
