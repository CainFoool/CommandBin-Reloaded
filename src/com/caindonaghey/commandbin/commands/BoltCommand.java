package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class BoltCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("bolt")) {
			if(!(s instanceof Player)) {
				if(args.length < 1) {
					System.out.println("[CommandBin] " + Phrases.get("bolt-usage"));
					return true;
				}
				
				if(args.length > 1) {
					System.out.println("[CommandBin] " + Phrases.get("invalid-arguments"));
					return true;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				
				if(player == null) {
					System.out.println("[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				
				player.getWorld().strikeLightning(player.getLocation());
				System.out.println("[CommandBin] " + Phrases.get("bolt-striked"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.bolt")) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.getWorld().strikeLightning(player.getTargetBlock(null, 0).getLocation());
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("bolt-striked"));
				return true;
			}
			
			if(args.length == 1) {
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				
				if(otherPlayer == null) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				
				otherPlayer.getWorld().strikeLightning(otherPlayer.getLocation());
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("bolt-player"));
				return true;
			}
			
			player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
		}
		return true;
	}

}
