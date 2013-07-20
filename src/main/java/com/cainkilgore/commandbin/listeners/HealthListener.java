package com.cainkilgore.commandbin.listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import com.cainkilgore.commandbin.CommandBin;

public class HealthListener implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(CommandBin.plugin.getConfig().getBoolean("settings.healthtags")) {
			registerZombie(e.getEntity(), e.getDamage());
			registerSpider(e.getEntity(), e.getDamage());
			registerSkeleton(e.getEntity(), e.getDamage());
			registerCreeper(e.getEntity(), e.getDamage());
		}
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		if(CommandBin.plugin.getConfig().getBoolean("settings.healthtags")) {
			registerZombie(e.getEntity());
			registerSpider(e.getEntity());
			registerSkeleton(e.getEntity());
			registerCreeper(e.getEntity());
			simonTheSheep(e.getEntity());
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
	
	public void simonTheSheep(Entity entity) {
		Random random = new Random();
		if(entity instanceof Sheep) {
			if(random.nextInt(1000) == 20) {
				Sheep sheep = (Sheep) entity;
				sheep.setCustomName("Simon The Sheep");
				sheep.setColor(DyeColor.PINK);
				sheep.setCustomNameVisible(true);
			}
		}
	}
	
	// For the damage
	
	public void registerZombie(Entity entity, double d) {
		if(entity instanceof Zombie) {
			Zombie zombie = (Zombie) entity;
			zombie.setCustomName(ChatColor.RED + "Health: " + (zombie.getHealth() - d));
		}
	}
	public void registerSpider(Entity entity, double d) {
		if(entity instanceof Spider) {
			Spider spider = (Spider) entity;
			spider.setCustomName(ChatColor.RED + "Health: " + (spider.getHealth() - d));
		}
	}
	public void registerSkeleton(Entity entity, double d) {
		if(entity instanceof Skeleton) {
			Skeleton skeleton = (Skeleton) entity;
			skeleton.setCustomName(ChatColor.RED + "Health: " + (skeleton.getHealth() - d));
		}
	}
	
	public void registerCreeper(Entity entity, double d) {
		if(entity instanceof Creeper) {
			Creeper creeper = (Creeper) entity;
			creeper.setCustomName(ChatColor.RED + "Health: " + (creeper.getHealth() - d));
		}
	}

}
