package com.cainkilgore.commandbin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Special {
	
	public static void giveSpecial(Player player, String special) {
		if(special.equalsIgnoreCase("kbstick")) {
			ItemStack stick = new ItemStack(Material.STICK, 1);
			stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 20);
			stick.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, -100);
			ItemMeta m = stick.getItemMeta();
			m.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "The Knockback Stick");
			stick.setItemMeta(m);
			player.getInventory().addItem(stick);
		}
		
		if(special.equalsIgnoreCase("superbow")) {
			ItemStack bow = new ItemStack(Material.BOW, 1);
			bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 100);
			bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 100);
			bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 100);
			bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
			bow.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 100);
			bow.addUnsafeEnchantment(Enchantment.DIG_SPEED, 100);
			
			ItemMeta m = bow.getItemMeta();
			m.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "The Super Bow");
			bow.setItemMeta(m);
			Inventory.setItemDescription(bow, ChatColor.YELLOW + "can kill a Wither in two shots!");
			player.getInventory().addItem(bow);
			player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
		}
	}

}
