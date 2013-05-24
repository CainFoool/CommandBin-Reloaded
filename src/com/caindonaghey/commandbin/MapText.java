package com.caindonaghey.commandbin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;

import com.caindonaghey.commandbin.commands.MapCommand;

public class MapText extends MapRenderer {
	
	String currentText;
	
	public MapText(String text) {
		this.currentText = text;
	}
	
	@Override
	public void render(MapView arg0, MapCanvas arg1, Player arg2) {
		if(arg0.getId() == MapCommand.newID) {
			String finalText = currentText.replace("\\n","\n");
			arg1.drawText(0, 0, MinecraftFont.Font, finalText);
			//arg2.sendMap(arg0);
		}
	}
	

}
