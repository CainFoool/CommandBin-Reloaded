package com.cainkilgore.commandbin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventory {

	public static void setItemDescription(ItemStack is, String description) {
        List <String> lore = new ArrayList<String>();
        lore.add(description);
        ItemMeta im = is.getItemMeta();
        im.setLore(lore);
        is.setItemMeta(im);
	}
	
	public static void setItemName(ItemStack is, String name) {
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		is.setItemMeta(im);
	}
}
