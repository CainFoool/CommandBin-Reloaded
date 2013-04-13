package com.caindonaghey.commandbin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.caindonaghey.commandbin.Phrases;
import com.caindonaghey.commandbin.commands.BlockCommand;

public class BlockedListener implements Listener {
	
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		
		if(BlockCommand.blockedPlayers.contains(playerName)) {
			player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("blocked-from-commands"));
			e.setCancelled(true);
		}
	}

}
