package com.cainkilgore.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;

import com.cainkilgore.commandbin.Phrases;

public class WitherCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("wither")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.wither")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			for(int i = 0; i < 5; i++) {
				 player.launchProjectile(WitherSkull.class).setVelocity(player.getVelocity());
			}
		}
		return true;
	}

} 
