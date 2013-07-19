package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class PutCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("put")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.put.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				
				player.teleport(player.getTargetBlock(null, 0).getLocation().getBlock().getRelative(0, 2, 0).getLocation());
				player.sendMessage(Phrases.get("teleported"));
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.put.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				otherPlayer.teleport(player.getTargetBlock(null, 0).getRelative(0, 2, 0).getLocation());
				player.sendMessage(Phrases.get("teleported"));
				return true;
			}
			player.sendMessage(Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
