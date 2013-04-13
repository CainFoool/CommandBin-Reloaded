package com.caindonaghey.commandbin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;
import com.caindonaghey.commandbin.Warp;

public class SetwarpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("setwarp")) {
			if(!(s instanceof Player)) {
				System.out.println("[CommandBin] " + Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.setwarp")) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
				return false;
			}
				Warp.saveWarp(player, args[0].toLowerCase());
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("warp-set"));
		}
		return true;
	}

}
