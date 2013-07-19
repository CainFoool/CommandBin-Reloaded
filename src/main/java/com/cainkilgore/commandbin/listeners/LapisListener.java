package com.cainkilgore.commandbin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.cainkilgore.commandbin.CommandBin;

public class LapisListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		final Player player = e.getPlayer();
		
		// player.sendMessage(player.getLocation().getBlock().getRelative(0, -1, 0).getType().name());
		
		if(CommandBin.lapisTrampoline) {
			
			if(player.getLocation().getBlock().getRelative(0, -1, 0).getType() == Material.LAPIS_BLOCK) {
				player.setVelocity(new Vector(0, 1 + Vector.getRandom().getY(), 0));
			}
		}
	}

}
