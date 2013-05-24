package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class VoteNoCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("voteno")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.no")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(VoteCommand.voteRunning) {
				if(VoteCommand.votePlayers.contains(player.getName())) {
					player.sendMessage(Phrases.get("already-voted"));
					return true;
				}
				
				if(VoteCommand.playerList.contains(player.getName())) {
					VoteCommand.votePlayers.add(player.getName());
					VoteCommand.no++;
					Bukkit.getServer().broadcastMessage(Phrases.get("vote-bro").replace("{PLAYER}", player.getName()).replace("{VOTE}", "no").replace("{1}", Integer.toString(VoteCommand.yes)).replace("{2}", Integer.toString(VoteCommand.no)));
					player.sendMessage(Phrases.get("thanks-voting"));
					VoteCommand.playerList.remove(player.getName());
					VoteCommand.votePlayers.add(player.getName());
					
					if(VoteCommand.playerList.isEmpty()) {
						
						if(VoteCommand.yes == VoteCommand.no) {
							Bukkit.getServer().broadcastMessage(Phrases.get("vote-tied"));
							VoteCommand.voteRunning = false;
							VoteCommand.no = 0;
							VoteCommand.yes = 0;
							VoteCommand.votePlayers.clear();
							return true;
						}
						
						if(VoteCommand.yes > VoteCommand.no) {
							Bukkit.getServer().broadcastMessage(Phrases.get("vote-yes"));
							VoteCommand.voteRunning = false;
							VoteCommand.no = 0;
							VoteCommand.yes = 0;
							VoteCommand.votePlayers.clear();
							return true;
						}
						Bukkit.getServer().broadcastMessage(Phrases.get("vote-no"));
						VoteCommand.voteRunning = false;
						VoteCommand.no = 0;
						VoteCommand.yes = 0;
						VoteCommand.votePlayers.clear();
					}
					return true;
				}
				player.sendMessage(Phrases.get("vote-elegible"));
				return true;
			}
			
			player.sendMessage(Phrases.get("vote-not-running"));
		}
		return true;
	}

}
