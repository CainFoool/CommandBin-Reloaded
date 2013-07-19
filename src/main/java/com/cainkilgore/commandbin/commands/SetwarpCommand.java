package com.cainkilgore.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.Warp;

public class SetwarpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("setwarp")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.setwarp")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args[0].equalsIgnoreCase("list")) {
				return false;
			}
				Warp.saveWarp(player, args[0].toLowerCase());
				player.sendMessage(Phrases.get("warp-set"));
		}
		return true;
	}

}
