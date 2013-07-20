package com.cainkilgore.commandbin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.cainkilgore.commandbin.commands.IceCommand;

public class IceListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		
		if(IceCommand.icePlayers.contains(player.getName())) {
			for(int i = -1; i < 2; i++) {
				for(int y = -1; y < 2; y++) {
					if(player.getLocation().getBlock().getRelative(i, -1, y).getType() == Material.STATIONARY_WATER) {
						player.getLocation().getBlock().getRelative(i, -1, y).setType(Material.ICE);
					}
				}
			}
		}
	}

}
