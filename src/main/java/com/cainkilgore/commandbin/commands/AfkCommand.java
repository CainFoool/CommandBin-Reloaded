package com.cainkilgore.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class AfkCommand implements CommandExecutor {
	
	public static HashSet<String> AFKPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("afk")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
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
				Bukkit.getServer().broadcastMessage(Phrases.get("afk-announce").replace("{PLAYER}", player.getName()));
				return true;
			}
			
			AFKPlayers.remove(player.getName());
			Bukkit.getServer().broadcastMessage(Phrases.get("afk-announce-off").replace("{PLAYER}", player.getName()));
			player.sendMessage(Phrases.get("no-afk"));
			
		}
		return true;
	}

}
