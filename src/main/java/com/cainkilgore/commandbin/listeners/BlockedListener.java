package com.cainkilgore.commandbin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.commands.BlockCommand;

public class BlockedListener implements Listener {
	
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		
		if(BlockCommand.blockedPlayers.contains(playerName)) {
			player.sendMessage(Phrases.get("blocked-from-commands"));
			e.setCancelled(true);
		}
	}

}
