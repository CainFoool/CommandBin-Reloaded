package com.caindonaghey.commandbin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.caindonaghey.commandbin.commands.AfkCommand;
import com.caindonaghey.commandbin.commands.BlockCommand;
import com.caindonaghey.commandbin.commands.BoltCommand;
import com.caindonaghey.commandbin.commands.BroadcastCommand;
import com.caindonaghey.commandbin.commands.ChunkCommand;
import com.caindonaghey.commandbin.commands.ClearChatCommand;
import com.caindonaghey.commandbin.commands.ClearCommand;
import com.caindonaghey.commandbin.commands.CommandBinCommand;
import com.caindonaghey.commandbin.commands.CraftCommand;
import com.caindonaghey.commandbin.commands.DelwarpCommand;
import com.caindonaghey.commandbin.commands.ExplodeCommand;
import com.caindonaghey.commandbin.commands.ExplosionbowCommand;
import com.caindonaghey.commandbin.commands.FeedCommand;
import com.caindonaghey.commandbin.commands.FireworkCommand;
import com.caindonaghey.commandbin.commands.FlyCommand;
import com.caindonaghey.commandbin.commands.FreezeCommand;
import com.caindonaghey.commandbin.commands.FsayCommand;
import com.caindonaghey.commandbin.commands.GmCommand;
import com.caindonaghey.commandbin.commands.GodCommand;
import com.caindonaghey.commandbin.commands.HatCommand;
import com.caindonaghey.commandbin.commands.HealCommand;
import com.caindonaghey.commandbin.commands.HomeCommand;
import com.caindonaghey.commandbin.commands.IPCommand;
import com.caindonaghey.commandbin.commands.ItemdescCommand;
import com.caindonaghey.commandbin.commands.ItemnameCommand;
import com.caindonaghey.commandbin.commands.KillCommand;
import com.caindonaghey.commandbin.commands.KillmobsCommand;
import com.caindonaghey.commandbin.commands.MuteCommand;
import com.caindonaghey.commandbin.commands.NickCommand;
import com.caindonaghey.commandbin.commands.OpeninvCommand;
import com.caindonaghey.commandbin.commands.PtimeCommand;
import com.caindonaghey.commandbin.commands.SethomeCommand;
import com.caindonaghey.commandbin.commands.SetspawnCommand;
import com.caindonaghey.commandbin.commands.SetwarpCommand;
import com.caindonaghey.commandbin.commands.SmokeCommand;
import com.caindonaghey.commandbin.commands.SpawnCommand;
import com.caindonaghey.commandbin.commands.SpawnmobCommand;
import com.caindonaghey.commandbin.commands.StarveCommand;
import com.caindonaghey.commandbin.commands.TimeCommand;
import com.caindonaghey.commandbin.commands.TpAcceptCommand;
import com.caindonaghey.commandbin.commands.TpCommand;
import com.caindonaghey.commandbin.commands.TpDenyCommand;
import com.caindonaghey.commandbin.commands.TpaCommand;
import com.caindonaghey.commandbin.commands.TpallCommand;
import com.caindonaghey.commandbin.commands.TphereCommand;
import com.caindonaghey.commandbin.commands.VanishCommand;
import com.caindonaghey.commandbin.commands.WarpCommand;
import com.caindonaghey.commandbin.commands.WeatherCommand;
import com.caindonaghey.commandbin.listeners.AfkListener;
import com.caindonaghey.commandbin.listeners.BlockedListener;
import com.caindonaghey.commandbin.listeners.BowListener;
import com.caindonaghey.commandbin.listeners.FreezeListener;
import com.caindonaghey.commandbin.listeners.GodListener;
import com.caindonaghey.commandbin.listeners.MuteListener;
import com.caindonaghey.commandbin.listeners.SmokeListener;
import com.caindonaghey.commandbin.listeners.VanishListener;

public class CommandBin extends JavaPlugin {
	
	public static CommandBin plugin;
	public static String language;
	
	public void onEnable() {
		registerCommands();
		registerEvents();
		registerTimeLock();
		setupConfig();
		setupLanguage();
		System.out.println(Phrases.get("enabled"));
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
		if(getConfig().get("language") == null) {
			getConfig().set("language", "english");
			saveConfig();
		}
	}
	
	public void setupLanguage() {
		if(getConfig().getString("language").equalsIgnoreCase("english")) {
			language = "english";
		}
		if(getConfig().getString("language").equalsIgnoreCase("dutch") || getConfig().getString("language").equalsIgnoreCase("deutch")) {
			language = "dutch";
		}
	}

}
