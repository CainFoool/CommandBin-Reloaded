package com.cainkilgore.commandbin.commands;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class FlyCommand implements CommandExecutor {
	
	public static HashSet<String> flyingPlayers = new HashSet<String>();
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("fly")) {
			if(!(s instanceof Player)) {
				if(args.length != 1) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				
				if(!flyingPlayers.contains(player.getName())) {
					flyingPlayers.add(player.getName());
					System.out.println(Phrases.get("player-fly"));
					player.sendMessage(Phrases.get("self-fly-enabled"));
					player.setFlying(true);
					return true;
				}
				
				flyingPlayers.remove(player.getName());
				player.sendMessage(Phrases.get("self-fly-disabled"));
				System.out.println(Phrases.get("player-nofly"));
				player.setFlying(false);
				return true;
			}
			
			Player player = (Player) s;
			
			if(args.length == 0) {
				if(!player.hasPermission("CommandBin.fly.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				
				if(!flyingPlayers.contains(player.getName())) {
					flyingPlayers.add(player.getName());
					player.sendMessage(Phrases.get("fly-self"));
					player.setAllowFlight(true);
					player.setFlying(true);
					return true;
				}
				flyingPlayers.remove(player.getName());
				player.sendMessage(Phrases.get("nofly-self"));
				player.setAllowFlight(false);
				player.setFlying(false);
				return true;
			}
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.fly.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				
				if(!flyingPlayers.contains(otherPlayer.getName())) {
					flyingPlayers.add(otherPlayer.getName());
					otherPlayer.sendMessage(Phrases.get("self-fly-enabled"));
					player.sendMessage(Phrases.get("player-fly"));
					otherPlayer.setAllowFlight(true);
					otherPlayer.setFlying(true);
					return true;
				}
				otherPlayer.sendMessage(Phrases.get("self-fly-disabled"));
				flyingPlayers.remove(otherPlayer.getName());
				otherPlayer.setAllowFlight(false);
				otherPlayer.setFlying(false);
				player.sendMessage(Phrases.get("player-nofly"));
				return true;
			}
			
			player.sendMessage(Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
