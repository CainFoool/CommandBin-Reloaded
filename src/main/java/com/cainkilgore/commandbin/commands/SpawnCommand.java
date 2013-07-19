package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.Spawn;

public class SpawnCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("spawn")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				
				player.teleport(Spawn.returnSpawnLocation(player));
				System.out.println(Phrases.get("spawn-player"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.spawn.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				player.teleport(Spawn.returnSpawnLocation(player));
				player.sendMessage(Phrases.get("player-tele-spawn"));
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.spawn.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				otherPlayer.teleport(Spawn.returnSpawnLocation(otherPlayer));
				player.sendMessage(Phrases.get("spawn-player"));
			}
			
			if(args.length > 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
		}
		return true;
	}

}
