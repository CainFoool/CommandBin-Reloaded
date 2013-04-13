package com.caindonaghey.commandbin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Warp {
	
	public static void saveWarp(Player player, String name) {
		CommandBin.plugin.getConfig().set("warp." + name + ".world", player.getWorld().getName());
		CommandBin.plugin.getConfig().set("warp." + name + ".x", player.getLocation().getX());
		CommandBin.plugin.getConfig().set("warp." + name + ".y", player.getLocation().getY());
		CommandBin.plugin.getConfig().set("warp." + name + ".z", player.getLocation().getZ());
		
		CommandBin.plugin.saveConfig();
	}
	
	public static Location getWarp(String name) {
		World world = Bukkit.getServer().getWorld(CommandBin.plugin.getConfig().getString("warp." + name + ".world"));
		int x = CommandBin.plugin.getConfig().getInt("warp." + name + ".x");
		int y = CommandBin.plugin.getConfig().getInt("warp." + name + ".y");
		int z = CommandBin.plugin.getConfig().getInt("warp." + name + ".z");
		return new Location(world, x, y, z);
	}
	
	public static boolean doesExist(String name) {
		if(CommandBin.plugin.getConfig().getString("warp." + name + ".world") == null) {
			return false;
		}
		return true;
	}

}
