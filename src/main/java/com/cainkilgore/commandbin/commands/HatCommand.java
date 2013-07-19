package com.cainkilgore.commandbin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.cainkilgore.commandbin.Phrases;

public class HatCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("hat")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.hat")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 0) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(player.getInventory().getHelmet() != null) {
				player.getInventory().addItem(new ItemStack(player.getInventory().getHelmet().getType(), 1));
				player.getInventory().setHelmet(new ItemStack(Material.AIR, 0));
			}
			player.getInventory().setHelmet(player.getItemInHand());
			player.getItemInHand().setType(Material.AIR);
			player.getInventory().remove(player.getItemInHand());
			player.sendMessage(Phrases.get("hat"));
		}
		return true;
	}

}
