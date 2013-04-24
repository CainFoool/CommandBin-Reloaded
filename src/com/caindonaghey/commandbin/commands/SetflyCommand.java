package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Phrases;

public class SetflyCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("setfly")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			Player player = (Player) s;
			
			if(args.length == 1) {
				if(!player.hasPermission("CommandBin.setfly.self")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				int speed = 0;
				try {
					speed = Integer.parseInt(args[0]) / 100;
				} catch (NumberFormatException e) {
					player.sendMessage(Phrases.get("invalid-number"));
					return true;
				}
				try {
				player.setFlySpeed(speed);
				player.sendMessage(Phrases.get("speed-set").replace("{SPEED}", args[0]));
				} catch (IllegalArgumentException e) {
					player.sendMessage(Phrases.get("invalid-number"));
				}
				return true;
			}
			
			if(args.length == 2) {
				if(!player.hasPermission("CommandBin.setfly.others")) {
					player.sendMessage(Phrases.get("no-permission"));
					return true;
				}
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				try {
					otherPlayer.setFlySpeed(Integer.parseInt(args[1]));
					player.sendMessage(Phrases.get("speed-set").replace("{SPEED}", args[0]));
				} catch (NumberFormatException e) {
					player.sendMessage(Phrases.get("invalid-number"));
				}
			}
			
			player.sendMessage(Phrases.get("invalid-arguments"));
			return false;
		}
		return true;
	}

}
