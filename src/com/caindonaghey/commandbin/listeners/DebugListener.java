package com.caindonaghey.commandbin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.caindonaghey.commandbin.CommandBin;

public class DebugListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		if(CommandBin.debugOnce && player.isOp()) {
			player.sendMessage(ChatColor.GREEN + "Hello.");
			player.sendMessage(ChatColor.GREEN + "Developer of CommandBin here.");
			player.sendMessage(ChatColor.GREEN + "You will only receive this message once.");
			player.sendMessage(ChatColor.GREEN + "I'm just letting you know of this..");
			player.sendMessage(ChatColor.GREEN + "Fireworks are buggy, and occasionally the randomizer");
			player.sendMessage(ChatColor.GREEN + "may not work very well.");
			player.sendMessage(ChatColor.GREEN + "That's all, this message will no longer appear.");
			
			CommandBin.debugOnce = false;
			CommandBin.plugin.getConfig().set("settings.debugonce", false);
			CommandBin.plugin.saveConfig();
		}
	}

}
