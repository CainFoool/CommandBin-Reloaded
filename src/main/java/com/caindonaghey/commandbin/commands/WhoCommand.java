package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class WhoCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("who")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.who")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
			if(otherPlayer == null) {
				player.sendMessage(Phrases.get("player-invalid"));
				return true;
			}
			
			player.sendMessage(Phrases.prefix + "== Details on " + otherPlayer.getName() + " ==");
			player.sendMessage(Phrases.prefix + "Name: " + otherPlayer.getName());
			player.sendMessage(Phrases.prefix + "IP: " + otherPlayer.getAddress().getAddress().toString().replace("/", ""));
			player.sendMessage(Phrases.prefix + "Health: " + getHealth(otherPlayer));
			player.sendMessage(Phrases.prefix + "Hunger: " + getHunger(otherPlayer));
			player.sendMessage(Phrases.prefix + "Experience: " + otherPlayer.getExp() + " (" + otherPlayer.getLevel() + " levels)");
			player.sendMessage(Phrases.prefix + "GameMode: " + otherPlayer.getGameMode());
			player.sendMessage(Phrases.prefix + "X: " + otherPlayer.getLocation().getX());
			player.sendMessage(Phrases.prefix + "Y: " + otherPlayer.getLocation().getY());
			player.sendMessage(Phrases.prefix + "Z: " + otherPlayer.getLocation().getZ());
			player.sendMessage(Phrases.prefix + "Pitch: " + otherPlayer.getLocation().getPitch());
			player.sendMessage(Phrases.prefix + "Yaw: " + otherPlayer.getLocation().getYaw());
			player.sendMessage(Phrases.prefix + "World: " + otherPlayer.getWorld().getName());
		}
		return true;
	}
	
	public String getHealth(Player player) {
		StringBuilder x = new StringBuilder();
		for(int i = 0; i < player.getHealth(); i++) {
			x.append(ChatColor.GREEN + "#");
		}
		return x.toString() + ChatColor.WHITE + "(" + player.getHealth() + ")";
	}
	
	public String getHunger(Player player) {
		StringBuilder x = new StringBuilder();
		for(int i = 0; i < player.getFoodLevel(); i++) {
			x.append(ChatColor.GREEN + "#");
		}
		return x.toString() + ChatColor.WHITE + "(" + player.getFoodLevel() + ")";
	}

}
