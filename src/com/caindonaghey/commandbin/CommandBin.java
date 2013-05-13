package com.caindonaghey.commandbin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.caindonaghey.commandbin.commands.*;
import com.caindonaghey.commandbin.listeners.*;

public class CommandBin extends JavaPlugin {
	
	public static CommandBin plugin;
	public static String language;
	public static boolean lapisTrampoline = false;
	public static boolean chunkLoader = false;
	public static boolean debugOnce = false;
	
	public void onEnable() {
		registerCommands();
		registerEvents();
		registerTimeLock();
		setupConfig();
		setupLanguage();
		setupLapis();
		setupLoader();
		System.out.println(Phrases.get("enabled"));
		System.out.println("CommandBin is sponsored by VPSCraft.net!");
		System.out.println("Language currently set to: " + getConfig().get("language"));
		System.out.println("Health Tags currently set to: " + getConfig().get("healthtags"));
		plugin = this;
	}
	
	public void onDisable() {
		System.out.println(Phrases.get("disabled"));
	}
	
	
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new BlockedListener(), this);
		getServer().getPluginManager().registerEvents(new AfkListener(), this);
		getServer().getPluginManager().registerEvents(new FreezeListener(), this);
		getServer().getPluginManager().registerEvents(new GodListener(), this);
		getServer().getPluginManager().registerEvents(new MuteListener(), this);
		getServer().getPluginManager().registerEvents(new VanishListener(), this);
		getServer().getPluginManager().registerEvents(new BowListener(), this);
		getServer().getPluginManager().registerEvents(new SmokeListener(), this);
		getServer().getPluginManager().registerEvents(new BindListener(), this);
		getServer().getPluginManager().registerEvents(new HealthListener(), this);
		getServer().getPluginManager().registerEvents(new LapisListener(), this);
		getServer().getPluginManager().registerEvents(new ChunkLoaderListener(), this);
		getServer().getPluginManager().registerEvents(new BlockplaceListener(), this);
		getServer().getPluginManager().registerEvents(new DebugListener(), this);
	}
	
	public void registerCommands() {
		getServer().getPluginCommand("afk").setExecutor(new AfkCommand());
		getServer().getPluginCommand("block").setExecutor(new BlockCommand());
		getServer().getPluginCommand("bolt").setExecutor(new BoltCommand());
		getServer().getPluginCommand("broadcast").setExecutor(new BroadcastCommand());
		getServer().getPluginCommand("clear").setExecutor(new ClearCommand());
		getServer().getPluginCommand("explode").setExecutor(new ExplodeCommand());
		getServer().getPluginCommand("feed").setExecutor(new FeedCommand());
		getServer().getPluginCommand("freeze").setExecutor(new FreezeCommand());
		getServer().getPluginCommand("fsay").setExecutor(new FsayCommand());
		getServer().getPluginCommand("gm").setExecutor(new GmCommand());
		getServer().getPluginCommand("god").setExecutor(new GodCommand());
		getServer().getPluginCommand("heal").setExecutor(new HealCommand());
		getServer().getPluginCommand("kill").setExecutor(new KillCommand());
		getServer().getPluginCommand("mute").setExecutor(new MuteCommand());
		getServer().getPluginCommand("time").setExecutor(new TimeCommand());
		getServer().getPluginCommand("tpaccept").setExecutor(new TpAcceptCommand());
		getServer().getPluginCommand("tpa").setExecutor(new TpaCommand());
		getServer().getPluginCommand("tpdeny").setExecutor(new TpDenyCommand());
		getServer().getPluginCommand("spawn").setExecutor(new SpawnCommand());
		getServer().getPluginCommand("setspawn").setExecutor(new SetspawnCommand());
		getServer().getPluginCommand("starve").setExecutor(new StarveCommand());
		getServer().getPluginCommand("tpall").setExecutor (new TpallCommand());
		getServer().getPluginCommand("tp").setExecutor (new TpCommand());
		getServer().getPluginCommand("vanish").setExecutor(new VanishCommand());
		getServer().getPluginCommand("weather").setExecutor(new WeatherCommand());
		getServer().getPluginCommand("openinv").setExecutor(new OpeninvCommand());
		getServer().getPluginCommand("killmobs").setExecutor(new KillmobsCommand());
		getServer().getPluginCommand("fly").setExecutor(new FlyCommand());
		getServer().getPluginCommand("chunk").setExecutor(new ChunkCommand());
		getServer().getPluginCommand("commandbin").setExecutor(new CommandBinCommand());
		getServer().getPluginCommand("hat").setExecutor(new HatCommand());
		getServer().getPluginCommand("ip").setExecutor (new IPCommand());
		getServer().getPluginCommand("tphere").setExecutor(new TphereCommand());
		getServer().getPluginCommand("explosionbow").setExecutor (new ExplosionbowCommand());
		getServer().getPluginCommand("nick").setExecutor(new NickCommand());
		getServer().getPluginCommand("craft").setExecutor(new CraftCommand());
		getServer().getPluginCommand("clearchat").setExecutor(new ClearChatCommand());
		getServer().getPluginCommand("home").setExecutor(new HomeCommand());
		getServer().getPluginCommand("sethome").setExecutor(new SethomeCommand());
		getServer().getPluginCommand("setwarp").setExecutor(new SetwarpCommand());
		getServer().getPluginCommand("warp").setExecutor(new WarpCommand());
		getServer().getPluginCommand("ptime").setExecutor(new PtimeCommand());
		getServer().getPluginCommand("itemname").setExecutor(new ItemnameCommand());
		getServer().getPluginCommand("itemdesc").setExecutor(new ItemdescCommand());
		getServer().getPluginCommand("smoke").setExecutor(new SmokeCommand());
		getServer().getPluginCommand("delwarp").setExecutor(new DelwarpCommand());
		getServer().getPluginCommand("spawnmob").setExecutor(new SpawnmobCommand());
		getServer().getPluginCommand("firework").setExecutor(new FireworkCommand());
		getServer().getPluginCommand("bindstick").setExecutor(new BindstickCommand());
		getServer().getPluginCommand("put").setExecutor (new PutCommand());
		getServer().getPluginCommand("fixlag").setExecutor (new FixlagCommand());
		getServer().getPluginCommand("creeper").setExecutor(new CreeperCommand());
		getServer().getPluginCommand("msg").setExecutor(new MsgCommand());
		getServer().getPluginCommand("shoot").setExecutor(new ShootCommand());
		getServer().getPluginCommand("openenc").setExecutor(new OpenEncCommand());
		getServer().getPluginCommand("blockplace").setExecutor(new BlockplaceCommand());
	}
	
	public void registerTimeLock() {
	    getServer().getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
	        public void run() {
	        	if(TimeCommand.isLockRunning) {
	        		Bukkit.getServer().getWorld(TimeCommand.worldName).setTime(TimeCommand.worldTime); // to do. Test
	        	}
	        }
	      }
	      , 10L, 100L);
	}
	
	public void setupConfig() {
		if(getConfig().get("settings.language") == null) {
			getConfig().set("settings.language", "english");
			saveConfig();
		}
		if(getConfig().get("settings.healthtags") == null) {
			getConfig().set("settings.healthtags", true);
			saveConfig();
		}
		if(getConfig().get("settings.lapis-trampoline") == null) {
			getConfig().set("settings.lapis-trampoline", true);
			saveConfig();
		}
		if(getConfig().get("settings.chunk-loader") == null) {
			getConfig().set("settings.chunk-loader", true);
			saveConfig();
		}
		if(getConfig().get("settings.debugonce") == null) {
			getConfig().set("settings.debugonce", true);
			saveConfig();
		}
	}
	
	public void setupLanguage() {
		if(getConfig().getString("settings.language").equalsIgnoreCase("english")) {
			language = "english";
		}
		if(getConfig().getString("settings.language").equalsIgnoreCase("dutch") || getConfig().getString("settings.language").equalsIgnoreCase("deutch")) {
			language = "dutch";
		}
	}
	
	public void setupLapis() {
		if(getConfig().getBoolean("settings.lapis-trampoline")) {
			lapisTrampoline = true;
		}
	}
	
	public void setupLoader() {
		if(getConfig().getBoolean("settings.chunk-loader")) {
			chunkLoader = true;
		}
	}
	
	public void setupDebug() {
		if(getConfig().getBoolean("settings.debugonce")) {
			debugOnce = true;
		}
	}

}
