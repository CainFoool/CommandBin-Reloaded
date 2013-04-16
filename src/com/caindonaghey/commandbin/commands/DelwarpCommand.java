package com.caindonaghey.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.CommandBin;
import com.caindonaghey.commandbin.Phrases;

public class DelwarpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("delwarp")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				if(CommandBin.plugin.getConfig().get("warp." + args[0].toLowerCase()) != null) {
					CommandBin.plugin.getConfig().set("warp." + args[0].toLowerCase(), null);
					System.out.println(Phrases.get("warp-deleted"));
					return true;
				}
				System.out.println(Phrases.get("warp-invalid"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.delwarp")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(CommandBin.plugin.getConfig().get("warp." + args[0].toLowerCase()) != null) {
				CommandBin.plugin.getConfig().set("warp." + args[0].toLowerCase(), null);
				player.sendMessage(Phrases.get("warp-deleted"));
				return true;
			}
			player.sendMessage(Phrases.get("warp-invalid"));
		}
		return true;
	}

}
