package com.caindonaghey.commandbin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.caindonaghey.commandbin.commands.LockdownCommand;

public class LockdownListener implements Listener {
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		if(LockdownCommand.lockdownKick) {
			if(!e.getPlayer().hasPermission("CommandBin.lockdownexempt")) {
				e.disallow(Result.KICK_BANNED, ChatColor.RED + "The server is in lockdown mode.");
			}
		}
	}

}
