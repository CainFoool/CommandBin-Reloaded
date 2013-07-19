package com.cainkilgore.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class VoteCommand implements CommandExecutor {
	
	public static boolean voteRunning = false;
	public static HashSet<String> votePlayers = new HashSet<String>();
	public static HashSet<String> playerList = new HashSet<String>();
	
	public static int yes = 0;
	public static int no = 0;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("vote")) {
			if(!(s instanceof Player)) {
				if(args.length < 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				if(args[0].equalsIgnoreCase("stop")) {
					if(voteRunning) {
						voteRunning = false;
						votePlayers.clear();
						Bukkit.getServer().broadcastMessage(Phrases.get("vote-cancelled"));
						return true;
					}
					System.out.println(Phrases.get("vote-not-running"));
					return true;
				}
				
				if(voteRunning) {
					System.out.println(Phrases.get("vote-running"));
					return true;
				}
				
				StringBuilder x = new StringBuilder();
				for(int i = 0; i < args.length; i++) {
					x.append(args[i] + " ");
				}
				
				voteRunning = true;
				Bukkit.getServer().broadcastMessage(Phrases.get("vote-started-1"));
				Bukkit.getServer().broadcastMessage(Phrases.get("vote-started-2").replace("{VOTE}", x.toString().trim()));
				Bukkit.getServer().broadcastMessage(Phrases.get("vote-started-3"));
				
				for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
					playerList.add(onlinePlayers.getName());
				}
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.vote")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args[0].equalsIgnoreCase("stop")) {
				if(voteRunning) {
					voteRunning = false;
					votePlayers.clear();
					Bukkit.getServer().broadcastMessage(Phrases.get("vote-cancelled"));
					return true;
				}
				player.sendMessage(Phrases.get("vote-not-running"));
				return true;
			}
			
			if(voteRunning) {
				player.sendMessage(Phrases.get("vote-running"));
				return true;
			}
			
			StringBuilder x = new StringBuilder();
			for(int i = 0; i < args.length; i++) {
				x.append(args[i] + " ");
			}
			
			voteRunning = true;
			Bukkit.getServer().broadcastMessage(Phrases.get("vote-started-1"));
			Bukkit.getServer().broadcastMessage(Phrases.get("vote-started-2").replace("{VOTE}", x.toString().trim()));
			Bukkit.getServer().broadcastMessage(Phrases.get("vote-started-3"));
			
			for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
				playerList.add(onlinePlayers.getName());
			}
		}
		return true;
	}

}
