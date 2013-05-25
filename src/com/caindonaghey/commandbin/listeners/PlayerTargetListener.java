package com.caindonaghey.commandbin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

import com.caindonaghey.commandbin.commands.NotargetCommand;

public class PlayerTargetListener implements Listener {
	
	@EventHandler
	public void onEntityTarget(EntityTargetEvent e) {
		if(e.getTarget() instanceof Player) {
			Player player = (Player) e.getTarget();
			if(NotargetCommand.targetPlayers.contains(player.getName())) {
				e.setCancelled(true);
			}
		}
	}

}
