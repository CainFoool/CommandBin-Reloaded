package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class TpallCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("tpall")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.tpall")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 0) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			for(Player allPlayers : Bukkit.getServer().getOnlinePlayers()) {
				if(allPlayers.getName() != player.getName()) {
					allPlayers.teleport(player.getLocation());
				}
			}
			player.sendMessage(Phrases.get("tele-all"));
		}
		return true;
	}

}
