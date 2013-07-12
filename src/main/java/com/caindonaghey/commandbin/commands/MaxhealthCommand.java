package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class MaxhealthCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("maxhealth")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.maxhealth")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args.length == 1) {
				try {
					int maxHealth = Integer.parseInt(args[0]);
					player.setMaxHealth(maxHealth);
					player.sendMessage(Phrases.prefix + "Max health has been set to " + maxHealth + ".");
					} catch (NumberFormatException e) {
						player.sendMessage(Phrases.get("bad-number"));
				}
				
				return true;
			}
			
			if(args.length == 2) {
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				try {
					int maxHealth = Integer.parseInt(args[1]);
					otherPlayer.setMaxHealth(maxHealth);
					player.sendMessage(Phrases.prefix + otherPlayer.getName() + "'s max health has been set to " + maxHealth + ".");
				} catch (NumberFormatException e) {
					player.sendMessage(Phrases.get("bad-number"));
				}
				return true;
			}
		}
			return true;
	}

}
