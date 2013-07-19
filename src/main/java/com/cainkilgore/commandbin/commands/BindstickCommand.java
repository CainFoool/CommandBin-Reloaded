package com.cainkilgore.commandbin.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class BindstickCommand implements CommandExecutor {
	
	public static HashMap<String, String> bindPlayers = new HashMap<String, String>(); 
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("bindstick")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.bindstick")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				if(bindPlayers.containsKey(player.getName())) {
					bindPlayers.remove(player.getName());
					player.sendMessage(Phrases.get("unbind-stick"));
					return true;
				}
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			StringBuilder x = new StringBuilder();
			for(int i = 0; i < args.length; i++) {
				x.append(args[i] + " ");
			}
			bindPlayers.put(player.getName(), x.toString());
			player.sendMessage(Phrases.get("bind-stick"));
			
		}
		return true;
	}

}
