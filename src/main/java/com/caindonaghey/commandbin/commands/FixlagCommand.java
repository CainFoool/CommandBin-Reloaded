package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class FixlagCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("fixlag")) {
			if(!(s instanceof Player)) {
				for(World world : Bukkit.getServer().getWorlds()) {
					for(Entity entity : world.getEntities()) {
						if(entity instanceof Item) {
							entity.remove();
						}
					}
				}
				System.out.println(Phrases.get("lag-fixed"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.fixlag")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			for(World world : Bukkit.getServer().getWorlds()) {
				for(Entity entity : world.getEntities()) {
					if(entity instanceof Item) {
						entity.remove();
					}
				}
			}
			
			player.sendMessage(Phrases.get("lag-fixed"));
		}
		return true;
	}

}
