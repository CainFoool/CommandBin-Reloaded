package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class TextpackCommand implements CommandExecutor {

	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("textpack")) {
			if(!(s instanceof Player)) {
				if(args.length < 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				for(Player player : Bukkit.getServer().getOnlinePlayers()) {
					player.setTexturePack(args[0]);
				}
				return true;
			}
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.textpack")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
				onlinePlayers.setTexturePack(args[0]);
			}
		}
		return true;
	}
	
	

}
