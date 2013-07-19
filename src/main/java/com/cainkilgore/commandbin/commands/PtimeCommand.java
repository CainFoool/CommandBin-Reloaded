package com.cainkilgore.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class PtimeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("ptime")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			if(args.length != 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			
			if(args[0].equalsIgnoreCase("day")) {
				if(!player.hasPermission("CommandBin.ptime.day")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				player.setPlayerTime(0, false);
				player.sendMessage(Phrases.get("time-set") + args[0].toLowerCase());
				return true;
			}
			
			if(args[0].equalsIgnoreCase("night")) {
				if(!player.hasPermission("CommandBin.ptime.night")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				player.setPlayerTime(14400, false);
				player.sendMessage(Phrases.get("time-set") + args[0].toLowerCase());
				return true;
			}
			if(args[0].equalsIgnoreCase("reset")) {
				if(!player.hasPermission("CommandBin.ptime.reset")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				player.resetPlayerTime();
				player.sendMessage(Phrases.get("time-unlocked"));
			}
		}
		return true;
	}

}
