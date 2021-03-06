package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.CommandBin;
import com.cainkilgore.commandbin.Phrases;

public class TimeCommand implements CommandExecutor {
	
	public static boolean isLockRunning = false;
	public static String worldName;
	public static long worldTime;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("time")) {
			if(!(s instanceof Player)) {
				if(args.length < 2) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				World world = Bukkit.getServer().getWorld(args[0]);
				if(world == null) {
					System.out.println(Phrases.get("invalid-world"));
					return true;
				}
				
				if(args[1].equalsIgnoreCase("day")) {
					world.setTime(0);
					System.out.println(Phrases.get("time-set") + args[1].toLowerCase());
					return true;
				}
				
				if(args[1].equalsIgnoreCase("night")) {
					world.setTime(14400);
					System.out.println(Phrases.get("time-set") + args[1].toLowerCase());
					return true;
				}
				
				if(args[1].equalsIgnoreCase("lock")) {
					if(!isLockRunning) {
						isLockRunning = true;
						worldName = world.getName();
						worldTime = world.getTime();
						CommandBin.plugin.getConfig().set("settings.time-lock", true);
						CommandBin.plugin.getConfig().set("settings.time-lock-time", worldTime);
						CommandBin.plugin.getConfig().set("settings.time-lock-world", worldName);
						CommandBin.plugin.saveConfig();
						System.out.println(Phrases.get("time-locked"));
						return true;
					}
					isLockRunning = false;
					CommandBin.plugin.getConfig().set("settings.time-lock", false);
					CommandBin.plugin.saveConfig();
					System.out.println(Phrases.get("time-unlocked"));
					return true;
				}
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.time")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args[0].equalsIgnoreCase("set")) {
				if(args.length < 2) {
					player.sendMessage(Phrases.get("invalid-arguments"));
					return false;
				}
				
				try {
				Integer timeSet = Integer.parseInt(args[1]);
				player.getWorld().setTime(timeSet);
				player.sendMessage(Phrases.get("time-set") + timeSet);
				} catch (NumberFormatException e) {
					player.sendMessage(Phrases.get("invalid-number"));
				}
				return true;
			}
			
			if(args[0].equalsIgnoreCase("day")) {
				player.getWorld().setTime(0);
				player.sendMessage(Phrases.get("time-set") + args[0].toLowerCase());
				return true;
			}
			
			if(args[0].equalsIgnoreCase("night")) {
				player.getWorld().setTime(14400);
				player.sendMessage(Phrases.get("time-set") + args[0].toLowerCase());
				return true;
			}
			
			if(args[0].equalsIgnoreCase("lock")) {
				if(!isLockRunning) {
					isLockRunning = true;
					worldName = player.getWorld().getName();
					worldTime = player.getWorld().getTime();
					CommandBin.plugin.getConfig().set("settings.time-lock", true);
					CommandBin.plugin.getConfig().set("settings.time-lock-time", worldTime);
					CommandBin.plugin.getConfig().set("settings.time-lock-world", worldName);
					CommandBin.plugin.saveConfig();
					player.sendMessage(Phrases.get("time-locked"));
					return true;
				}
				isLockRunning = false;
				CommandBin.plugin.getConfig().set("settings.time-lock", false);
				CommandBin.plugin.saveConfig();
				player.sendMessage(Phrases.get("time-unlocked"));
				return true;
			}
			return true;
		}
		return true;
	}

}
