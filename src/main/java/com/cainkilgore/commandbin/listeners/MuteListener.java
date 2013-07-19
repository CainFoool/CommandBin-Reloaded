package com.cainkilgore.commandbin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.commands.LockdownCommand;
import com.cainkilgore.commandbin.commands.MuteCommand;

public class MuteListener implements Listener {

	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		
		if(MuteCommand.mutedPlayers.contains(playerName)) {
			e.setCancelled(true);
			player.sendMessage(Phrases.get("you-are-muted"));
		}
		
		if(!player.hasPermission("CommandBin.lockdownexempt")) {
			if(LockdownCommand.serverLockdown) {
				e.setCancelled(true);
			}
		}
	}

}
