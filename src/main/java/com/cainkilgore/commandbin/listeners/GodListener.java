package com.cainkilgore.commandbin.listeners;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.cainkilgore.commandbin.CommandBin;
import com.cainkilgore.commandbin.commands.GodCommand;

public class GodListener implements Listener {
	
//	@EventHandler
//	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
//		if(e.getEntity() instanceof Player) {
//			Player player = (Player) e.getEntity();
//			
//			if(player.getGameMode() != GameMode.CREATIVE) {
//				double damage = e.getDamage();
//				e.setCancelled(true);
//				player.damage(damage);
//				if(CommandBin.plugin.getConfig().getBoolean("settings.classichurt")) {
//					player.playSound(player.getLocation(), Sound.HURT, 5, 1);
//				}
//			}
//		}
//		
//		if(e.getEntity() instanceof Player) {
//			if(GodCommand.godPlayers.contains(((Player) e.getEntity()).getName())) {
//				e.setCancelled(true);
//				((Player) e.getEntity()).setHealth(20);
//				// ((Player) e.getEntity()).sendMessage("Atempted to stop");
//			}
//		}
//	}
	
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if(GodCommand.godPlayers.contains(player.getName())) {
				e.setCancelled(true);
				return;
			}
			if(player.getGameMode() != GameMode.CREATIVE) {
				if(CommandBin.plugin.getConfig().getBoolean("settings.classichurt")) {
					player.playSound(player.getLocation(), Sound.HURT, 5, 1);
				}
			}
			
		}
	}

}
