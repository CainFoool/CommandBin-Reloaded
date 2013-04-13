package com.caindonaghey.commandbin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.caindonaghey.commandbin.Phrases;
import com.caindonaghey.commandbin.commands.AfkCommand;

public class AfkListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		
		if(AfkCommand.AFKPlayers.contains(playerName)) {
			AfkCommand.AFKPlayers.remove(playerName);
			player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("no-afk"));
		}
	}

}
