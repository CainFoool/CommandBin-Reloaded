package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class ExplodeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("explode")) {
			if(!(s instanceof Player)) {
				if(args.length < 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				
				if(player == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				
				player.getWorld().createExplosion(player.getLocation(), 5);
				System.out.println(Phrases.get("exploded"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				if(player.hasPermission("CommandBin.explode.self")) {
					player.getWorld().createExplosion(player.getLocation(), 5);
					player.sendMessage(Phrases.get("exploded"));
					return true;
				}
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length == 1) {
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(player.hasPermission("CommandBin.explode.others")) {
					if(otherPlayer == null) {
						player.sendMessage(Phrases.get("player-invalid"));
						return true;
					}
					otherPlayer.getWorld().createExplosion(player.getLocation(), 5);
					player.sendMessage(Phrases.get("exploded"));
					return true;
				}
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			player.sendMessage(Phrases.get("invalid-arguments"));
		}
		return true;
	}

}
