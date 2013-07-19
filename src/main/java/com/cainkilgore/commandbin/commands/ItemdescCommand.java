package com.cainkilgore.commandbin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Inventory;
import com.cainkilgore.commandbin.Phrases;

public class ItemdescCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("itemdesc")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			if(!player.hasPermission("CommandBin.itemdesc")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			if(args.length < 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			StringBuilder x = new StringBuilder();
			for(int i = 0; i < args.length; i++) {
				x.append(args[i] + " ");
			}
			Inventory.setItemDescription(player.getItemInHand(), x.toString().replace("&", "§"));
			player.sendMessage(Phrases.get("itemdesc-set"));
		}
		return true;
	}

}
