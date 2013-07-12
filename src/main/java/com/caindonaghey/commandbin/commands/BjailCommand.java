package com.caindonaghey.commandbin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class BjailCommand implements CommandExecutor {
	
	public boolean debug = true;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("bjail")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(debug) {
				player.sendMessage(ChatColor.RED + "This command is a test. Ignore this command.");
				return true;
			}
			if(!player.hasPermission("CommandBin.bjail")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			for(int i = -1; i < 2; i++) {
				for(int y = -1; y < 2; y++) {
					for(int up = 1; up < 3; up++) {
						player.getWorld().spawnFallingBlock(player.getTargetBlock(null, 0).getRelative(i, up, y).getLocation(), Material.BEDROCK, (byte) 1);
						player.getLocation().getBlock().getRelative(0,  up, 0).setType(Material.AIR);
					}
				}
			}
			
			
		}
		return true;
	}

}
