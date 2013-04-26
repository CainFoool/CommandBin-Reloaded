package com.caindonaghey.commandbin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import com.caindonaghey.commandbin.CommandBin;

public class HealthListener implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(CommandBin.plugin.getConfig().getBoolean("healthtags")) {
			registerZombie(e.getEntity(), e.getDamage());
			registerSpider(e.getEntity(), e.getDamage());
			registerSkeleton(e.getEntity(), e.getDamage());
			registerCreeper(e.getEntity(), e.getDamage());
		}
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		if(CommandBin.plugin.getConfig().getBoolean("healthtags")) {
			registerZombie(e.getEntity());
			registerSpider(e.getEntity());
			registerSkeleton(e.getEntity());
			registerCreeper(e.getEntity());
		}
	}
	
	public void registerZombie(Entity entity) {
		if(entity instanceof Zombie) {
			Zombie zombie = (Zombie) entity;
			zombie.setCustomName(ChatColor.RED + "Health: " + zombie.getHealth());
		}
	}
	public void registerSpider(Entity entity) {
		if(entity instanceof Spider) {
			Spider spider = (Spider) entity;
			spider.setCustomName(ChatColor.RED + "Health: " + spider.getHealth());
		}
	}
	public void registerSkeleton(Entity entity) {
		if(entity instanceof Skeleton) {
			Skeleton skeleton = (Skeleton) entity;
			skeleton.setCustomName(ChatColor.RED + "Health: " + skeleton.getHealth());
		}
	}
	
	public void registerCreeper(Entity entity) {
		if(entity instanceof Creeper) {
			Creeper creeper = (Creeper) entity;
			creeper.setCustomName(ChatColor.RED + "Health: " + creeper.getHealth());
		}
	}
	
	// For the damage
	
	public void registerZombie(Entity entity, int damage) {
		if(entity instanceof Zombie) {
			Zombie zombie = (Zombie) entity;
			zombie.setCustomName(ChatColor.RED + "Health: " + (zombie.getHealth() - damage));
		}
	}
	public void registerSpider(Entity entity, int damage) {
		if(entity instanceof Spider) {
			Spider spider = (Spider) entity;
			spider.setCustomName(ChatColor.RED + "Health: " + (spider.getHealth() - damage));
		}
	}
	public void registerSkeleton(Entity entity, int damage) {
		if(entity instanceof Skeleton) {
			Skeleton skeleton = (Skeleton) entity;
			skeleton.setCustomName(ChatColor.RED + "Health: " + (skeleton.getHealth() - damage));
		}
	}
	
	public void registerCreeper(Entity entity, int damage) {
		if(entity instanceof Creeper) {
			Creeper creeper = (Creeper) entity;
			creeper.setCustomName(ChatColor.RED + "Health: " + (creeper.getHealth() - damage));
		}
	}

}
