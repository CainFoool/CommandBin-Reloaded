package com.cainkilgore.commandbin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.commands.AfkCommand;

public class AfkListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		
		if(AfkCommand.AFKPlayers.contains(playerName)) {
			AfkCommand.AFKPlayers.remove(playerName);
			Bukkit.getServer().broadcastMessage(Phrases.get("afk-announce-off").replace("{PLAYER}", player.getName()));
		}
	}

}
