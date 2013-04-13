package com.caindonaghey.commandbin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.CommandBin;

public class CommandBinCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("commandbin")) {
			if(!(s instanceof Player)) {
				System.out.println("[CommandBin] CommandBin Version: v" + CommandBin.plugin.getDescription().getVersion());
				System.out.println("[CommandBin] Created by CainFool of http://dev.caindonaghey.com");
				return true;
			}
			
			Player player = (Player) s;
		
			player.sendMessage(ChatColor.GREEN + "[CommandBin] CommandBin Version: v" + CommandBin.plugin.getDescription().getVersion());
			player.sendMessage(ChatColor.GREEN + "[CommandBin] Created by CainFool of http://dev.caindonaghey.com");
		}
		return true;
	}

}
