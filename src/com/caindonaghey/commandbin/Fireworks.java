package com.caindonaghey.commandbin;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class Fireworks {
	
	public static void spawnFirework(Player player, Color color, Type type, int power) {
		Firework fw = player.getWorld().spawn(player.getTargetBlock(null, 0).getLocation(), Firework.class);
		FireworkMeta fwm = fw.getFireworkMeta();
		           
		FireworkEffect effect = FireworkEffect.builder().withColor(color).with(type).build();
		       
		fwm.addEffects(effect);
		fwm.setPower(power);       
		fw.setFireworkMeta(fwm);
	}
	
    public static Color getColorFrom(Player player, String sub) {
        Color color = null;
        if (sub.matches("(?i)#[0-9A-F]{6}")) {
            sub = sub.substring(1);

            int blue = Integer.valueOf(sub.substring(0, 2), 16);
            int red = Integer.valueOf(sub.substring(2, 4), 16);
            int green = Integer.valueOf(sub.substring(4, 6), 16);
            if (blue > 255)
                blue = 255;
            if (red > 255)
                red = 255;
            if (green > 255)
                green = 255;

            color = Color.fromBGR(blue, green, red);
        } else if (sub.matches("(?i)RICH.*")) {
            if (sub.equalsIgnoreCase("RICHGREEN")) {
                color = Color.GREEN;
            } else if (sub.equalsIgnoreCase("RICHRED")) {
                color = Color.RED;
            } else if (sub.equalsIgnoreCase("RICHBLUE")) {
                color = Color.BLUE;
            } else if (sub.equalsIgnoreCase("RICHYELLOW")) {
                color = Color.YELLOW;
            }
        } else {
            // FIXME: add ability to use Color values too - they are
            // richer/stronger colors
        	try {
            color = DyeColor.valueOf(sub.toUpperCase()).getColor();
        	} catch (IllegalArgumentException e) {
        		color = Color.RED;
        		player.sendMessage(Phrases.get("invalid-color"));
        	}
        }
        return color;
    }
    
    public static Type getTypeFrom(Player player, String sub) {
    	Type type = null;
    	
    	try {
    		type = Type.valueOf(sub.toUpperCase());
    	} catch (IllegalArgumentException e) {
    		type = Type.CREEPER;
    		player.sendMessage(Phrases.get("invalid-type"));
    	}
    	return type;
    }
}