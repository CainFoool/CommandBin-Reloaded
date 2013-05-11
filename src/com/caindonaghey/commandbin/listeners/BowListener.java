package com.caindonaghey.commandbin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import com.caindonaghey.commandbin.CommandBin;
import com.caindonaghey.commandbin.commands.ExplosionbowCommand;

public class BowListener implements Listener {
	
	@EventHandler
	public void EntityShootBow(EntityShootBowEvent e) {
		try {
		Entity projectile = e.getProjectile();
		if(projectile instanceof Arrow) {
			final Arrow arrow = (Arrow) projectile;
			if(arrow.getShooter() instanceof Player) {
					Player player = (Player) arrow.getShooter();
					if(ExplosionbowCommand.explosionBowPlayers.contains(player.getName())) {
						Bukkit.getScheduler().runTaskLater(CommandBin.plugin, new Runnable() {
							public void run() {
								if(arrow != null) {
									arrow.getWorld().createExplosion(arrow.getLocation(), 5);
									arrow.remove();
								}
							}
						}, 20 * 2);
					}
			}
		}
	}
		 catch (NullPointerException error) {
				// Noes!
			}
	}

}
