package com.cainkilgore.commandbin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.cainkilgore.commandbin.Phrases;
import com.cainkilgore.commandbin.Warp;

public class WarpSignListener implements Listener {
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onSignChange(SignChangeEvent e) {
		if(e.getPlayer().hasPermission("CommandBin.setwarp")) {
			if(e.getLine(0).equalsIgnoreCase("[Warp]")) {
				if(Warp.doesExist(e.getLine(1))) {
					e.setLine(0, ChatColor.GREEN + e.getLine(0));
					e.getPlayer().sendMessage(Phrases.prefix + "Warp sign has been created, you can now right click.");
					return;
				}
				e.getPlayer().sendMessage(Phrases.badPrefix + "That warp does not exist.");
				e.getBlock().breakNaturally();
			}
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Sign sign = (Sign) e.getClickedBlock().getState();
				
				if(sign.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "[Warp]")) {
					if(e.getPlayer().hasPermission("CommandBin.warp")) {
						e.getPlayer().teleport(Warp.getWarp(sign.getLine(1)));
						e.getPlayer().sendMessage(Phrases.prefix + "Teleported to warp '" + sign.getLine(1) + "'.");
					} else {
						e.getPlayer().sendMessage(Phrases.get("no-permission").replace("run this command", "interact with this"));
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(e.getBlock().getType() == Material.SIGN_POST || e.getBlock().getType() == Material.WALL_SIGN) {
			Sign sign = (Sign) e.getBlock().getState();
			if(sign.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "[Warp]")) {
				if(!e.getPlayer().hasPermission("CommandBin.setwarp")) {
					e.setCancelled(true);
					e.getPlayer().sendMessage(Phrases.badPrefix + "You cannot break warp signs.");
				}
			}
		}
	}

}
