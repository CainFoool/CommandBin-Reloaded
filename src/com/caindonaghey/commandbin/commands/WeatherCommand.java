package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.caindonaghey.commandbin.Inventory;
import com.caindonaghey.commandbin.Phrases;

public class WeatherCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("weather")) {
			if(!(s instanceof Player)) {
				if(args.length != 2) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				World world = Bukkit.getServer().getWorld(args[0]);
				
				if(world == null) {
					System.out.println(Phrases.get("invalid-world"));
					return true;
				}
				
				if(args[1].equalsIgnoreCase("sun")) {
					world.setStorm(false);
					world.setThundering(false);
					System.out.println(Phrases.get("rain-stopped"));
					return true;
				}
				
				if(args[1].equalsIgnoreCase("men")) {
					System.out.println("[CommandBin] Hallelujah!");
					return true;
				}
				
				if(args[1].equalsIgnoreCase("rain")) {
					world.setStorm(true);
					world.setThundering(true);
					System.out.println(Phrases.get("rain-start"));
					return true;
				}
			}
			
			Player player = (Player) s;
			

			if(!player.hasPermission("CommandBin.weather")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args.length > 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args[0].equalsIgnoreCase("sun")) {
				player.getWorld().setStorm(false);
				player.getWorld().setThundering(false);
				player.sendMessage(Phrases.get("rain-stopped"));
				return true;
			}
			
			if(args[0].equalsIgnoreCase("men")) {
				player.sendMessage(ChatColor.GREEN + "[CommandBin] Hallelujah! (Look up)");
				for(int i = 0; i <= 400; i++) {
					player.getWorld().spawnEntity(new Location(player.getWorld(), player.getLocation().getX() + Math.random() * 20, player.getLocation().getY() + 40 + i,  player.getLocation().getZ() - Math.random() * 20), EntityType.VILLAGER);
					player.getWorld().spawnEntity(new Location(player.getWorld(), player.getLocation().getX() - Math.random() * 20, player.getLocation().getY() + 40 + i,  player.getLocation().getZ() + Math.random() * 20), EntityType.VILLAGER);
					player.getWorld().spawnEntity(new Location(player.getWorld(), player.getLocation().getX() - Math.random() * 20, player.getLocation().getY() + 40 + i,  -player.getLocation().getZ() + Math.random() * 20), EntityType.VILLAGER);
					player.getWorld().spawnEntity(new Location(player.getWorld(), -player.getLocation().getX() - Math.random() * 20, player.getLocation().getY() + 40 + i,  player.getLocation().getZ() + Math.random() * 20), EntityType.VILLAGER);
				}
				return true;
			}
			
			if(args[0].equalsIgnoreCase("rain")) {
				player.getWorld().setStorm(true);
				player.getWorld().setThundering(true);
				player.sendMessage(Phrases.get("rain-start"));
				return true;
			}
		}
		return true;
	}

}
