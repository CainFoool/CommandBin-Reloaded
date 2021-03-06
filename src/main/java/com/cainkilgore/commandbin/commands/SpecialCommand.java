package com.cainkilgore.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.Special;

public class SpecialCommand implements CommandExecutor {
	
	String[] specials = { "kbstick", "superbow" };
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("special")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length < 1) {
				StringBuilder x = new StringBuilder();
				for(String spec : specials) {
					x.append(spec + ", ");
				}
				player.sendMessage(Phrases.prefix + x.toString().trim());
			}
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("kbstick")) {
					if(!player.hasPermission("CommandBin.special.kbstick")) {
						player.sendMessage(Phrases.get("no-permission"));
						return true;
					}
					Special.giveSpecial(player, "kbstick");
					return true;
				}
				
				if(args[0].equalsIgnoreCase("superbow")) {
					if(!player.hasPermission("CommandBin.special.superbow")) {
						player.sendMessage(Phrases.get("no-permission"));
						return true;
					}
					Special.giveSpecial(player, "superbow");
					return true;
				}
				player.sendMessage(Phrases.badPrefix + "Invalid special entered.");
				return false;
			}
		}
		return true;
	}

}
