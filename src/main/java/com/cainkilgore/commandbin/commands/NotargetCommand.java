package com.cainkilgore.commandbin.commands;

import java.util.HashSet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class NotargetCommand implements CommandExecutor {
	
	public static HashSet<String> targetPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("notarget")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.notarget")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(!targetPlayers.contains(player.getName())) {
				targetPlayers.add(player.getName());
				player.sendMessage(Phrases.get("target-on"));
				return true;
			}
			targetPlayers.remove(player.getName());
			player.sendMessage(Phrases.get("target-off"));
		}
		return true;
	}

}
