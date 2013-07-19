package com.cainkilgore.commandbin.listeners;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.cainkilgore.commandbin.commands.SmokeCommand;

public class SmokeListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		if(SmokeCommand.smokePlayers.contains(playerName)) {
			player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 5);
		}
	}

}
