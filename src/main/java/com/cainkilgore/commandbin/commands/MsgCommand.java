package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class MsgCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("msg")) {
			if(!(s instanceof Player)) {
				if(args.length < 2) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if(player == null) {
					System.out.println(Phrases.get("player-invalid"));
					return true;
				}
				StringBuilder x = new StringBuilder();
				for(int i = 1; i < args.length; i++) {
					x.append(args[i] + " ");
				}
				System.out.println("Console > " + x.toString().trim());
				player.sendMessage(ChatColor.DARK_AQUA + "Console > " + ChatColor.DARK_GRAY + x.toString().trim());
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.msg")) {
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
			player.sendMessage(ChatColor.AQUA + player.getName() + " to " + otherPlayer.getName() + " > " + ChatColor.DARK_GRAY + x.toString().trim());
			otherPlayer.sendMessage(ChatColor.DARK_AQUA + otherPlayer.getName() + " to " + player.getName() + " > " + ChatColor.DARK_GRAY + x.toString().trim());
			System.out.println("[CommandBin] " + player.getName() + " to " + otherPlayer.getName() + " > " + x.toString().trim());
			for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()) {
				if(SpyCommand.spyPlayers.contains(onlinePlayers.getName())) {
					onlinePlayers.sendMessage(ChatColor.DARK_AQUA + player.getName() + " to " + otherPlayer.getName() + " > " + ChatColor.DARK_GRAY + x.toString().trim());
				}
			}
		}
		return true;
	}

}
