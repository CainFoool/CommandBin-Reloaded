package com.caindonaghey.commandbin.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class GoUpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("goup")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.goup")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			try {
				int upBlock = Integer.parseInt(args[0]);
				player.getLocation().getBlock().getRelative(0, upBlock, 0).setType(Material.GLASS);
				player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + upBlock + 2, player.getLocation().getZ()));
			} catch (NumberFormatException e) {
				player.sendMessage(Phrases.get("bad-number"));
			}
		}
		return true;
	}

}
