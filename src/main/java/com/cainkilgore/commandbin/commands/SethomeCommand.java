package com.cainkilgore.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Home;
import com.cainkilgore.commandbin.Phrases;

public class SethomeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("sethome")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.sethome")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
				Home.saveHome(player);
				player.sendMessage(Phrases.get("home-set"));
		}
		return true;
	}

}
