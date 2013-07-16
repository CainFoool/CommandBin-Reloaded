package com.caindonaghey.commandbin;

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
	}

}
