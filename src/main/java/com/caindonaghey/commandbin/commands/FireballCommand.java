package com.caindonaghey.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class FireballCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("fireball")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.fireball")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			player.launchProjectile(LargeFireball.class).setVelocity(player.getVelocity());
		}
		return true;
	}

}
