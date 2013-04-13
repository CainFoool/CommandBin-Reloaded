package com.caindonaghey.commandbin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Home {
	
	public static void saveHome(Player player) {
		CommandBin.plugin.getConfig().set("home." + player.getName() + ".world", player.getWorld().getName());
		CommandBin.plugin.getConfig().set("home." + player.getName() + ".x", player.getLocation().getX());
		CommandBin.plugin.getConfig().set("home." + player.getName() + ".y", player.getLocation().getY());
		CommandBin.plugin.getConfig().set("home." + player.getName() + ".z", player.getLocation().getZ());
		
		CommandBin.plugin.saveConfig();
	}
	
	public static Location getHome(Player player) {
		World world = Bukkit.getServer().getWorld(CommandBin.plugin.getConfig().getString("home." + player.getName() + ".world"));
		int x = CommandBin.plugin.getConfig().getInt("home." + player.getName() + ".x");
		int y = CommandBin.plugin.getConfig().getInt("home." + player.getName() + ".y");
		int z = CommandBin.plugin.getConfig().getInt("home." + player.getName() + ".z");
		return new Location(world, x, y, z);
	}
	
	public static boolean ifHasHome(Player player) {
		if(CommandBin.plugin.getConfig().getString("home." + player.getName() + ".world") == null) {
			return false;
		}
		return true;
	}

}
