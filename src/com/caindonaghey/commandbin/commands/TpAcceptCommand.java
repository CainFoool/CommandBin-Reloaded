package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class TpAcceptCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("tpaccept")) {
			if(!(s instanceof Player)) {
				System.out.println("[CommandBin] " + Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.tpaccept")) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length != 1) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("invalid-arguments"));
				return true;
			}
			
			Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
			
			if(otherPlayer == null) {
				player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("player-invalid"));
				return true;
			}
			
			if(TpaCommand.tpaPlayers.containsKey(player.getName()) && TpaCommand.tpaPlayers.get(player.getName()) == otherPlayer.getName()) {
				otherPlayer.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("teleport-request-accepted"));
				player.sendMessage(ChatColor.GREEN + "[CommandBin] " + Phrases.get("teleport-request-allow"));
				otherPlayer.teleport(player);
				TpaCommand.tpaPlayers.remove(player.getName());
				return true;
			}
			
			player.sendMessage(ChatColor.RED + "[CommandBin] " + Phrases.get("teleport-request-invalid"));
		}
		return true;
	}

}
