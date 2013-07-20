package com.cainkilgore.commandbin;

import java.util.Random;

import org.bukkit.DyeColor;

public class RandomColor {
	
	public static DyeColor returnRandomColor() {
		Random random = new Random();
		int randomInt = random.nextInt(16);
		return DyeColor.getByWoolData((byte) randomInt);	
	}

}
