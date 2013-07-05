package com.caindonaghey.commandbin;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Spawn {
	
	public static Location returnSpawnLocation(Player player) {
		if(CommandBin.plugin.getConfig().get("spawn." + player.getWorld().getName()) != null) {
				String world = player.getWorld().getName();
				int x = CommandBin.plugin.getConfig().getInt("spawn." + world + ".x");
				int y = CommandBin.plugin.getConfig().getInt("spawn." + world + ".y");
				int z = CommandBin.plugin.getConfig().getInt("spawn." + world + ".z");
				int pitch = CommandBin.plugin.getConfig().getInt("spawn." + world + ".pitch");
				int yaw = CommandBin.plugin.getConfig().getInt("spawn." + world + ".yaw");
				Location spawn = new Location(player.getWorld(), x, y, z);
				spawn.setPitch(pitch);
				spawn.setYaw(yaw);
				return spawn;
		}
		return player.getWorld().getSpawnLocation();
	}
	
	public static void setSpawnLocation(Player player) {
		String world = player.getWorld().getName();
		CommandBin.plugin.getConfig().set("spawn." + world + ".x", player.getLocation().getX());
		CommandBin.plugin.getConfig().set("spawn." + world + ".y", player.getLocation().getY());
		CommandBin.plugin.getConfig().set("spawn." + world + ".z", player.getLocation().getZ());
		CommandBin.plugin.getConfig().set("spawn." + world + ".pitch", player.getLocation().getPitch());
		CommandBin.plugin.getConfig().set("spawn." + world + ".yaw", player.getLocation().getYaw());
		CommandBin.plugin.saveConfig();
	}

}
