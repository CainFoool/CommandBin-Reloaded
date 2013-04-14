package com.caindonaghey.commandbin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;
import com.caindonaghey.commandbin.Warp;

public class WarpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("warp")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			if(!player.hasPermission("CommandBin.warp")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			if(Warp.doesExist(args[0].toLowerCase())) {
				player.teleport(Warp.getWarp(args[0].toLowerCase()));
				player.sendMessage(Phrases.get("warp-teleport"));
				return true;
			}
			player.sendMessage(Phrases.get("invalid-warp"));
		}
		return true;
	}

}
