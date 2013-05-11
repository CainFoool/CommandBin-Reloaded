package com.caindonaghey.commandbin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.caindonaghey.commandbin.commands.GodCommand;

public class GodListener implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			
			if(GodCommand.godPlayers.contains(player.getName())) {
				// player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 5);
				// nejcevoeie (Whatever his name was) didn't like this effect.
				e.setCancelled(true);
				player.setHealth(20);
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
