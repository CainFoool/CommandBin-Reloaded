package com.caindonaghey.commandbin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.caindonaghey.commandbin.CommandBin;

public class WeatherListener implements Listener {
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent e) {
		if(e.toWeatherState()) {
			if(!CommandBin.plugin.getConfig().getBoolean("settings.enable-downfall")) {
				e.setCancelled(true);
				System.out.println("[CommandBin] The weather change was cancelled via config.yml");
			}
		}
	}

}
