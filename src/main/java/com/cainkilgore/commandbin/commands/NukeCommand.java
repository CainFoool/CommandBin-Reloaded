package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class NukeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("nuke")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.nuke")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
			if(otherPlayer == null) {
				player.sendMessage(Phrases.get("player-invalid"));
				return true;
			}
			
//			Entity eo = player.getWorld().spawn(player.getLocation().getBlock().getRelative(0, 10, 0).getLocation(), ExperienceOrb.class);
//			if(eo instanceof ExperienceOrb) {
//				((ExperienceOrb) eo).setExperience(100);
//			}
			
			nukePlayer(otherPlayer);
			player.sendMessage(Phrases.prefix + otherPlayer.getName() + " has been nuked.");
		}
		return true;
	}
	
	public void nukePlayer(Player player) {
		for(int i = -6; i < 7; i++) {
			for(int y = -6; y < 7; y++) {
				player.getWorld().spawnEntity(player.getLocation().getBlock().getRelative(i, 10, y).getLocation(), EntityType.PRIMED_TNT);
			}	
		}
	}

}
