package com.cainkilgore.commandbin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.cainkilgore.commandbin.commands.BindstickCommand;

public class BindListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Action action = e.getAction();
		
		if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
			if(player.getItemInHand().getType() == Material.STICK) {
				if(BindstickCommand.bindPlayers.containsKey(player.getName())) {
					player.chat(BindstickCommand.bindPlayers.get(player.getName()));
				}
			}
		}
	}

}
