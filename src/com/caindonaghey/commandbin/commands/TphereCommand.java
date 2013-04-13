package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class TphereCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("tphere")) {
			if(!(s instanceof Player)) {
				System.out.println("[CommandBin]" + Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.tphere")) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
				return false;
			}
			
			Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
			if(otherPlayer == null) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("player-invalid"));
				return true;
			}
			player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("tele-player"));
			otherPlayer.teleport(player.getLocation());
		}
		return true;
	}
	// TO DO.

}
