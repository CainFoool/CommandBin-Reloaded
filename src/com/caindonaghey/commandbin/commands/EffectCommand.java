package com.caindonaghey.commandbin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import com.caindonaghey.commandbin.Phrases;

public class EffectCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("effect")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.effect")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			// name, amp, time
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("list")) {
					StringBuilder x = new StringBuilder();
					for(PotionEffectType list : PotionEffectType.values()) {
							x.append(list + ", ");
					}
					player.sendMessage("Potion Effects Available: " );
					player.sendMessage(x.toString());
					return true;
				}
				return false;
			}
			if(args.length < 3) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			try {
			PotionEffectType name = PotionEffectType.getByName(args[0]);
			int amplifier = Integer.parseInt(args[1]);
			int time = Integer.parseInt(args[2]);
			
			if(name == null) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args.length == 4) {
				if(args[3].equalsIgnoreCase("hold")) {
					if(amplifier > 2) {
						amplifier = 2;
						player.sendMessage(Phrases.prefix + "Amplifier was too high for potions, defaulting to 2.");
					}
					
					ItemStack potion = new ItemStack(Material.POTION, 1);
					try {
					Potion p = new Potion(PotionType.valueOf(name.getName()), amplifier);
					p.setSplash(true);
					p.setHasExtendedDuration(true);
					p.apply(potion);
					player.getInventory().addItem(potion);
					player.sendMessage(Phrases.prefix + "Added to your inventory.");
					} catch (IllegalArgumentException e) {
						player.sendMessage(Phrases.badPrefix + "This item cannot be a splash potion.");
					}
				}
				return true;
			}
			
			player.addPotionEffect(new PotionEffect(name, time * 20, amplifier, true));
			player.sendMessage(Phrases.prefix + "Potion Effect Added.");
			} catch (NumberFormatException e) {
				player.sendMessage(Phrases.badPrefix + "Bad arguments, try again.");
				return false;
			}
		}
		return true;
	}

}
