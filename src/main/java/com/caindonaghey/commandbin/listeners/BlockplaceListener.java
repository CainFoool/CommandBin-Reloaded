package com.caindonaghey.commandbin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.caindonaghey.commandbin.Phrases;
import com.caindonaghey.commandbin.commands.BlockplaceCommand;
import com.caindonaghey.commandbin.commands.LockdownCommand;

public class BlockplaceListener implements Listener {
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		
		if(BlockplaceCommand.placePlayers.contains(player.getName())) {
			e.setCancelled(true);
			player.sendMessage(Phrases.get("no-blocks"));
		}
		
		if(!player.hasPermission("CommandBin.lockdownexempt")) {
			if(LockdownCommand.serverLockdown) {
				e.setCancelled(true);
			}
		}
	}

}
