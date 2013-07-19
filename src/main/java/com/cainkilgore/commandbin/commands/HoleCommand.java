package com.cainkilgore.commandbin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.commandbin.Phrases;

public class HoleCommand implements CommandExecutor {
	
	Material[] exemptBlocks = { Material.CHEST, Material.DIAMOND_ORE };
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(l.equalsIgnoreCase("hole")) {
			if(!(s instanceof Player)) {
				System.out.println(Phrases.get("no-console"));
				return true;
			}
			
			Player player = (Player) s;
			
			if(!player.hasPermission("CommandBin.hole")) {
				player.sendMessage(Phrases.get("no-permission"));
				return true;
			}
			
			if(args.length < 1) {
				player.sendMessage(Phrases.get("invalid-arguments"));
				return false;
			}
			
			if(args.length == 1) {
				Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
				if(otherPlayer == null) {
					player.sendMessage(Phrases.get("player-invalid"));
					return true;
				}
				
				for(int x = -1; x < 2; x++) {
					for(int z = -1; z < 2; z++) {
						for(int y = 0; y < 22; y++) {
							otherPlayer.getLocation().getBlock().getRelative(x, -y, z).setType(Material.AIR);
						}
					}
				}
			}
		}
		return true;
	}

}
