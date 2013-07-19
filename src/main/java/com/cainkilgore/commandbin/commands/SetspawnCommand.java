package com.cainkilgore.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.Spawn;

public class SetspawnCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("setspawn")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.setspawn")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 0) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			Spawn.setSpawnLocation(player);
			player.sendMessage(Phrases.get("spawn-set"));
			return true;
		}
		return true;
	}

}
