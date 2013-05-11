package com.caindonaghey.commandbin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.caindonaghey.commandbin.Phrases;
import com.caindonaghey.commandbin.commands.FreezeCommand;

public class FreezeListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		if(FreezeCommand.frozenPlayers.contains(playerName)) {
			player.sendMessage(Phrases.get("player-freeze-listener"));
			e.setCancelled(true);
		}
	}

}
