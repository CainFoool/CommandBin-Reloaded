package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class EnderCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("ender")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.ender")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				player.openInventory(player.getEnderChest());
				player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 1);
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.ender.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				player.openInventory(otherPlayer.getEnderChest());
				player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 1);
			}
		}
		return true;
	}

}
