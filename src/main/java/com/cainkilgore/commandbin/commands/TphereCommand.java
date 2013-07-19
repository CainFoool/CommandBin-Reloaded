package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class TphereCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("tphere")) {
			if(!(s instanceof Player)) {
				System.out.println("[CommandBin]" + Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.tphere")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
			if(otherPlayer == null) {
				player.sendMessage(Phrases.get("player-invalid"));
				return true;
			}
			player.sendMessage(Phrases.get("tele-player"));
			otherPlayer.teleport(player.getLocation());
			otherPlayer.sendMessage(Phrases.get("player-tp-1").replace("{PLAYER}", player.getName()).replace("{PLAYER}", "them"));
		}
		return true;
	}
	// TO DO.

}
