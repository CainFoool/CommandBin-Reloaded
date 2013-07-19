package com.cainkilgore.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.cainkilgore.commandbin.Phrases;

public class SpartaCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("sparta")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.sparta")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			for(Entity e : player.getNearbyEntities(10, 10, 10)) {
				e.setVelocity(new Vector(0, 2, 0));
				e.setFireTicks(20 * 10);
			}
			player.sendMessage(Phrases.get("sparta"));
		}
		return true;
	}

}
