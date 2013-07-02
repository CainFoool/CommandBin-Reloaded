package com.caindonaghey.commandbin.listeners;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.caindonaghey.commandbin.CommandBin;
import com.caindonaghey.commandbin.commands.GodCommand;

public class GodListener implements Listener {
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			
			if(GodCommand.godPlayers.contains(player.getName())) {
				// player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 5);
				// nejcevoeie (Whatever his name was) didn't like this effect.
				e.setCancelled(true);
				player.setHealth(20);
			}
			
			if(player.getGameMode() != GameMode.CREATIVE) {
					int damage = e.getDamage();
					e.setCancelled(true);
					player.damage(damage);
					if(CommandBin.plugin.getConfig().getBoolean("settings.classichurt")) {
						player.playSound(player.getLocation(), Sound.HURT, 5, 1);
					}
			
			}
		}
		
		if(e.getDamager() instanceof Player) {
			if(e.getEntity() instanceof Player) {
				Player player = (Player) e.getEntity();
				Player damager = (Player) e.getDamager();
					int damage = e.getDamage();
					e.setCancelled(true);
					player.damage(damage);
					if(CommandBin.plugin.getConfig().getBoolean("settings.classichurt")) {
						player.playSound(player.getLocation(), Sound.HURT, 5, 1);
						damager.playSound(damager.getLocation(), Sound.HURT, 5, 1);
				}
			}
		}
		
		/*
		if(e.getCause() == DamageCause.FALL) {
			e.setCancelled(true);
		}
		// Was testing stuff here.
		*/
	}

}
