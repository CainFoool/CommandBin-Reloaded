package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.listeners.KillListener;

public class KillCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("kill")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return true;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				
				player.damage(player.getMaxHealth());
				System.out.println(Phrases.get("kill-player"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.kill.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				
				// player.setHealth(0);
//				EntityDamageEvent e = player.getLastDamageCause();
//				player.setHealth(0);
				player.damage(player.getMaxHealth(), player.getLastDamageCause().getEntity());
//				player.setLastDamageCause(e);
				player.sendMessage(Phrases.get("kill-self"));
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.kill.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				
				otherPlayer.damage(otherPlayer.getMaxHealth());
				player.sendMessage(Phrases.get("kill-player"));
				return true;
			}
			
			player.sendMessage(Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
