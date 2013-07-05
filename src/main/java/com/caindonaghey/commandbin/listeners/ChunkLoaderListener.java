package com.caindonaghey.commandbin.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

import com.caindonaghey.commandbin.CommandBin;

public class ChunkLoaderListener implements Listener {
	
	@EventHandler
	 public void onChunkUnload(ChunkUnloadEvent event) {
		if(CommandBin.plugin.getConfig().getBoolean("settings.chunk-loader")) {
	       int X = event.getChunk().getX() * 16;
	       int Z = event.getChunk().getZ() * 16;
	       for (int x = 0; x < 16; x++) {
	           for (int z = 0; z < 16; z++) {
	               for (int y = 0; y < 128; y++) {
	                   if (event.getWorld().getBlockAt(X+x, y, Z+z).getType() == Material.LAPIS_BLOCK) {
	                      	event.setCancelled(true);
	                      	// System.out.println(Phrases.get("chunk-kept"));
	                   }
	               }
	           }
	       }
		}
	}

}
