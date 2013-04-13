package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class FsayCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("fsay")) {
			if(!(s instanceof Player)) {
				if(args.length < 2) {
					System.out.println("[CommandBin] " + Phrases.get("invalid-arguments"));
					return false;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println("[CommandBin] " + Phrases.get("player-invalid"));
					return true;
				}
				
				StringBuilder x = new StringBuilder();
				for(int i = 1; i < args.length; i++) {
					x.append(args[i] + " ");
				}
				
				player.chat(x.toString().trim());
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.fsay")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 2) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
			
			if(otherPlayer == null) {
				player.sendMessage(Phrases.get("player-invalid"));
				return true;
			}
			
			StringBuilder x = new StringBuilder();
			for(int i = 1; i < args.length; i++) {
				x.append(args[i] + " ");
			}
			otherPlayer.chat(x.toString().trim());
		}
		return true;
	}

}
