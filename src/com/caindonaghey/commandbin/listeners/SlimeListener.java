package com.caindonaghey.commandbin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.caindonaghey.commandbin.CommandBin;

public class SlimeListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent e) {
		//System.out.println("Moving.");
		for(Entity nearby : e.getPlayer().getNearbyEntities(3, 3, 3)) {
			if (nearby instanceof Slime) {
				//System.out.println("Is slime.");
				if(!e.getPlayer().isInsideVehicle()) {
					((Slime) nearby).setSize(1);
					//System.out.println("Not vehicle.");
					nearby.setPassenger(e.getPlayer());
					nearby.setVelocity(new Vector(0, 2, 0));
					Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(CommandBin.plugin, new Runnable() {
						public void run() {
							e.getPlayer().teleport(e.getPlayer().getLocation().getBlock().getRelative(0, 1, 0).getLocation());
						}
					}, 20 * 4);
				}
			}
		}
	}
	
	@EventHandler
	public void onSlimeSplit(SlimeSplitEvent e) {
		e.setCancelled(true);
	}

}
