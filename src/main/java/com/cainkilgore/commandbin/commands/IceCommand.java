package com.cainkilgore.commandbin.commands;

import java.util.HashSet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class IceCommand implements CommandExecutor {
	
	public static HashSet<String> icePlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("ice")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			if(!player.hasPermission("CommandBin.ice")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(!icePlayers.contains(player.getName())) {
				icePlayers.add(player.getName());
				player.sendMessage(Phrases.prefix + "Ice mode has been enabled.");
				return true;
			}
			icePlayers.remove(player.getName());
			player.sendMessage(Phrases.prefix + "Ice mode has been disabled.");
		}
		return true;
	}

}
