package com.caindonaghey.commandbin.commands;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;

import com.caindonaghey.commandbin.Phrases;

public class SpawnmobCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("spawnmob")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.spawnmob")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length == 0) {
				StringBuilder x = new StringBuilder();
				for(EntityType allMobs : EntityType.values()) {
					x.append(allMobs + ", ");
				}
				player.sendMessage(Phrases.prefix + x.toString());
				return true;
			}
			
			if(args.length == 1) {
				EntityType theMob = EntityType.valueOf(args[0].toUpperCase());
				Location cursorPos = player.getTargetBlock(null, 0).getRelative(0, 1, 0).getLocation();
				if(theMob != null) {
					
					if(theMob == EntityType.VILLAGER) {
						Villager villager = (Villager) player.getWorld().spawn(cursorPos, theMob.getEntityClass());
						villager.setProfession(chooseRandom());
						player.sendMessage(Phrases.get("mob-spawned"));
						return true;
					}

					player.getWorld().spawnEntity(cursorPos, theMob);
					player.sendMessage(Phrases.get("mob-spawned"));
					return true;
				}
				player.sendMessage(Phrases.get("invalid-mob"));
				return true;
			}
			
			if(args.length == 2) {
				EntityType theMob = EntityType.valueOf(args[0].toUpperCase());
				try {
				if(theMob != null) {
					Location cursorPos = player.getTargetBlock(null, 0).getRelative(0, 1, 0).getLocation();
					for(int i = 0; i < Integer.parseInt(args[1]); i++) {
						
						if(theMob == EntityType.VILLAGER) {
							Villager villager = (Villager) player.getWorld().spawn(cursorPos, theMob.getEntityClass());
							villager.setProfession(chooseRandom());
						} else {
						player.getWorld().spawnEntity(cursorPos, theMob);
						}
					}
					player.sendMessage(Phrases.get("mob-spawned"));
					return true;
				}
				player.sendMessage(Phrases.get("invalid-mob"));
				return true;
				} catch (NumberFormatException e) {
					player.sendMessage(Phrases.get("invalid-number"));
					return true;
				}
			}
			
			player.sendMessage(Phrases.get("invalid-arguments"));
			return false;
			
		}
		return true;
	}
	
	public Profession chooseRandom() {
		Random r = new Random();
		
		if(r.nextInt(5) == 1) {
			return Profession.BLACKSMITH;
		}
		if(r.nextInt(5) == 2) {
			return Profession.BUTCHER;
		}
		if(r.nextInt(5) == 3) {
			return Profession.FARMER;
		}
		if(r.nextInt(5) == 4) {
			return Profession.LIBRARIAN;
		}
		if(r.nextInt(5) == 5) {
			return Profession.PRIEST;
		}
		return Profession.BLACKSMITH;
	}

}
