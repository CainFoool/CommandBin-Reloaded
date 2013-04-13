package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class NickCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("nick")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println("[CommandBin] " + Phrases.get("invalid-arguments"));
					return false;
				}
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println("[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				player.setDisplayName(args[0]);
				System.out.println("[CommandBin] " + Phrases.get("name-changed"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.nick")) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
					return true;
				}
				
				player.setDisplayName(args[0]);
				return true;
			}
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.nick.others")) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				otherPlayer.setDisplayName(args[1]);
				return true;
			}
			return false;
		}
		return true;
	}

}
