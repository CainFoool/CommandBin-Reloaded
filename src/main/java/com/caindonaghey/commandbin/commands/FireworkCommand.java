package com.caindonaghey.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.caindonaghey.commandbin.Fireworks;
import com.caindonaghey.commandbin.Phrases;

public class FireworkCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("firework")) {
			if(!(s instanceof Player)) {
				if(args.length < 7) {
					System.out.println(Phrases.get("invalid-arguments"));
					return false;
				}
				
				if(args.length == 7) {
					
					World world = Bukkit.getServer().getWorld(args[0]);
					int x = Integer.parseInt(args[1]);
					int y = Integer.parseInt(args[2]);
					int z = Integer.parseInt(args[3]);
					try {
					Fireworks.spawnConsoleFirework(x, y, z, world, Fireworks.getColorFrom(args[4]), Fireworks.getTypeFrom(args[5]), Integer.parseInt(args[6]));
						System.out.println(Phrases.get("firework-spawned"));
					} catch (NumberFormatException e) {
						System.out.println(Phrases.get("invalid-number"));
						return false;
					}
				}
				return true;
			}
			
			Player player = (Player) s;
			if(!player.hasPermission("CommandBin.firework")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length == 0) {
				Fireworks.spawnFirework(player, Color.BLUE, Type.CREEPER, 2);
				player.sendMessage(Phrases.get("firework-spawned"));
				return true;
			}
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("list")) {
					player.sendMessage(ChatColor.DARK_RED + "Types: ");
					StringBuilder types = new StringBuilder();
					for(Type type : Type.values()) {
						types.append(type + ", ");
					}
					player.sendMessage(ChatColor.DARK_GREEN + types.toString());
					player.sendMessage(ChatColor.RED + "------------");
					player.sendMessage(ChatColor.DARK_RED + "Colors: ");
					StringBuilder colors = new StringBuilder();
					for(DyeColor color: DyeColor.values()) {
						colors.append(color + ", ");
					}
					player.sendMessage(ChatColor.DARK_GREEN + colors.toString());
					return false;
				}
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args.length < 3) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args.length == 3) {
				try {
				Fireworks.spawnFirework(player, Fireworks.getColorFrom(args[1]), Fireworks.getTypeFrom(args[0]), Integer.parseInt(args[2]));
				player.sendMessage(Phrases.get("firework-spawned"));
				} catch (NumberFormatException e) {
					player.sendMessage(Phrases.get("invalid-number"));
					return false;
				}
			}
		}
		return true;
	}

}
