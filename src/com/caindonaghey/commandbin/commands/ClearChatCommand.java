package com.caindonaghey.commandbin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class ClearChatCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("clearchat")) {
			if(!(s instanceof Player)) {
				System.out.println("[CommandBin] " + Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			if(!player.hasPermission("CommandBin.clearchat")) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
				return true;
			}
			for(int i = 0; i < 20; i++) {
				player.sendMessage("");
			}
			player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("chat-cleared"));
		}
		return true;
	}

}
