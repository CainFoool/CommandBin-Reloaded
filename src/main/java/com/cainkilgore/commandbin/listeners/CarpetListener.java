package com.cainkilgore.commandbin.listeners;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.cainkilgore.commandbin.CommandBin;
import com.cainkilgore.commandbin.commands.CarpetCommand;

public class CarpetListener implements Listener {
	
	boolean sneaking = false;
	public static HashSet<String> sneak = new HashSet<String>();
	
	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if(CarpetCommand.carpetPlayers.contains(player.getName())) {
			if(player.getLocation().getBlock().getRelative(0, -1, 0).getType() == Material.AIR) {
				if(!sneak.contains(player.getName())) {
					player.getLocation().getBlock().getRelative(0, -1, 0).setType(Material.GLASS);
				}
				Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(CommandBin.plugin, new Runnable() {
					public void run() {
						e.getFrom().getBlock().getRelative(0, -1, 0).setType(Material.AIR);
					}
				}, 20L * 20);
			}
		}
	}
	
	@EventHandler
	public void onPlayerToggleSneak(final PlayerToggleSneakEvent e) {
		if(CarpetCommand.carpetPlayers.contains(e.getPlayer().getName())) {
			if(e.isSneaking()) {
				sneak.add(e.getPlayer().getName());
				e.getPlayer().getWorld().playEffect(e.getPlayer().getLocation(), Effect.BLAZE_SHOOT, 5);
				//e.getPlayer().sendMessage("Sneaking.");
				e.getPlayer().getLocation().getBlock().getRelative(0, -1, 0).setType(Material.AIR);
				if(e.getPlayer().getLocation().getBlock().getRelative(0, -2, 0).getType() == Material.AIR) {
					e.getPlayer().getLocation().getBlock().getRelative(0, -2, 0).setType(Material.GLASS);
				}
			}
			Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(CommandBin.plugin, new Runnable() {
				public void run() {
					//sneaking = false;
					sneak.remove(e.getPlayer().getName());
				}
			}, 40L);
		}
	}

}
