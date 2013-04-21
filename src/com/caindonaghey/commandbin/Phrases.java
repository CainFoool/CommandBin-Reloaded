package com.caindonaghey.commandbin;

import org.bukkit.ChatColor;

public class Phrases {
	
	
	/*
	 * Future Languages:
	 * Spanish, German
	 * Need translators pls.
	 */
	
	public static String prefix = ChatColor.BLUE + "[" + ChatColor.GREEN + "CMDBin" + ChatColor.BLUE + "] " + ChatColor.GREEN;
	public static String badPrefix = ChatColor.RED + "[CommandBin] ";
	public static String get(String string) {
		
		if(CommandBin.language == "english") {
			if(string == "enabled") return prefix + "CommandBin has been enabled!";
			if(string == "disabled") return prefix + "CommandBin has been disabled!";
			if(string == "no-console") return badPrefix + "You may not use this command in console.";
			if(string == "invalid-arguments") return badPrefix + "You have entered invalid arguments.";
			if(string == "no-permission") return badPrefix + "You do not have permission to run this command.";
			if(string == "now-afk") return prefix + "You are now marked as AFK.";
			if(string == "no-afk") return prefix + "You are no longer marked as AFK.";
			if(string == "player-invalid") return badPrefix + "That player is not online.";
			if(string == "teleport-request-sent") return prefix + "Teleportation request has been sent.";
			if(string == "teleport-request-receive") return prefix + "wants to teleport to you.";
			if(string == "teleport-request-receive-2") return prefix + "/tpaccept <player> or /tpdeny <player>";
			if(string == "teleport-request-already") return badPrefix + "You have already sent a teleport request to this player.";
			if(string == "teleport-request-accepted") return prefix + "Your teleportation request has been accepted. Teleporting..";
			if(string == "teleport-request-allow") return prefix + "Accepted. One moment whilst I teleport them..";
			if(string == "teleport-request-invalid") return badPrefix + "No such teleport request exists.";
			if(string == "teleport-request-denied") return badPrefix + "Your teleport request has been denied.";
			if(string == "teleport-request-deny") return badPrefix + "Teleport request denied.";
			if(string == "player-blocked") return prefix + "This player is now blocked from using commands.";
			if(string == "player-unblocked") return prefix + "This player is now unblocked from using commands.";
			if(string == "blocked-from-commands") return badPrefix + "You are blocked from using commands.";
			if(string == "bolt-striked") return prefix + "Striked with lightning!";
			if(string == "bolt-player") return prefix + "Striked player with lightning!";
			if(string == "bolt-usage") return badPrefix + "/bolt [player]";
			if(string == "inventory-cleared") return prefix + "Inventory has been cleared.";
			if(string == "exploded") return prefix + "Boom!";
			if(string == "fed-self") return prefix + "You feel full now.";
			if(string == "fed-other") return prefix + "You have fed player. They feel full now.";
			if(string == "frozen-player") return prefix + "You have frozen this player.";
			if(string == "unfrozen-player") return prefix + "You have unfrozen this player.";
			if(string == "gamemode-switch") return prefix + "Player's gamemode has been switched.";
			if(string == "invalid-gamemode") return badPrefix + "Invalid gamemode has been specified.";
			if(string == "player-godmode") return prefix + "Player now has god mode.";
			if(string == "player-ungod") return prefix + "Player no longer has god mode.";
			if(string == "god-enabled") return prefix + "Godmode enabled.";
			if(string == "god-disabled") return prefix + "Godmode disabled.";
			if(string == "heal-other") return prefix + "You have healed this player.";
			if(string == "heal-self") return prefix + "You have healed yourself.";
			if(string == "kill-player") return prefix + "You have killed this player.";
			if(string == "kill-self") return prefix + "You have killed yourself.";
			if(string == "invalid-world") return badPrefix + "The world you have chosen does not exist.";
			if(string == "time-set") return prefix + "World time has been set to ";
			if(string == "time-locked") return prefix + "The time has been locked.";
			if(string == "time-unlocked") return prefix + "The time has been unlocked.";
			if(string == "player-muted") return prefix + "Player has been muted. They can no longer talk.";
			if(string == "player-unmuted") return prefix + "Player has been unmuted. They can now talk.";
			if(string == "you-are-muted") return badPrefix + "You cannot talk, you have been muted.";
			if(string == "spawn-set") return prefix + "World spawn has been set to your location.";
			if(string == "spawn-player") return prefix + "Teleported player to their current world spawn.";
			if(string == "player-tele-spawn") return prefix + "Teleported to your world spawn.";
			if(string == "starve-self") return prefix + "You have starved yourself.";
			if(string == "starve-others") return prefix + "You have starved another player.";
			if(string == "tele-all") return prefix + "You have teleport all online players to you.";
			if(string == "players-invalid") return badPrefix + "One of the players specified are not online.";
			if(string == "tele-1-2") return prefix + "Teleported Player 1 to Player 2";
			if(string == "invalid-numbers") return badPrefix + "Invalid co-ordinates entered.";
			if(string == "tele-1-co") return prefix + "Teleported player to specified co-ordinates.";
			if(string == "tele-player") return prefix + "Teleported to player";
			if(string == "player-vanish") return prefix + "This player is now vanished.";
			if(string == "player-visible") return prefix + "This player is now visible.";
			if(string == "self-invisible") return prefix + "You are now invisible.";
			if(string == "self-visible") return prefix + "You are no longer invisible.";
			if(string == "rain-stopped") return prefix + "It is now sunny.";
			if(string == "rain-start") return prefix + "It is now raining.";
			if(string == "removed-mobs") return prefix + "Removed all creatures from the world.";
			if(string == "player-fly") return prefix + "Player can now fly.";
			if(string == "player-nofly") return prefix + "Player can no longer fly.";
			if(string == "fly-self") return prefix + "You can now fly.";
			if(string == "nofly-self") return prefix + "You can no longer fly.";
			if(string == "chunk-reloaded") return prefix + "The chunk you are standing in has been reloaded.";
			if(string == "hat") return prefix + "You are now wearing a block hat!";
			if(string == "player-bow") return prefix + "Player can now use the explosion bow.";
			if(string == "player-nobow") return prefix + "Player can no longer use the explosion bow.";
			if(string == "self-bow") return prefix + "You may now use the explosion bow, be careful.";
			if(string == "self-nobow") return prefix + "You may no longer use the explosion bow.";
			if(string == "name-changed") return prefix + "Player's name has been changed!";
			if(string == "chat-cleared") return prefix + "Your chat has been cleared!";
			if(string == "home-set") return prefix + "Your home has been set!";
			if(string == "home-teleport") return prefix + "You have teleported to your home.";
			if(string == "invalid-home") return badPrefix + "You do not have a home! Use /sethome to set one!";
			if(string == "warp-set") return prefix + "Warp has been set!";
			if(string == "warp-teleport") return prefix + "You have teleported to this warp.";
			if(string == "invalid-warp") return badPrefix + "Warp non-existant. Use /setwarp to create one!";
			if(string == "itemname-set")  return prefix + "Item name has been set!";
			if(string == "itemdesc-set")  return prefix + "Item description has been set!";
			if(string == "player-smoke-on") return prefix + "Player will now have smoke whereever they walk.";
			if(string == "player-smoke-off") return prefix + "Player will no longer have smoke.";
			if(string == "self-smoke-on") return prefix + "You will now have smoke where you walk.";
			if(string == "self-smoke-off") return prefix + "You will no longer have smoke.";
			if(string == "warp-list") return prefix + "Warps: {WARPS}";
			if(string == "warp-deleted") return prefix + "Warp has been deleted.";
			if(string == "warp-invalid") return badPrefix + "This warp does not exist.";
			if(string == "mob-spawned") return prefix + "Mob has been spawned!";
			if(string == "invalid-mob") return badPrefix + "The mob you selected does not exist.";
			if(string == "invalid-number") return badPrefix + "Bad number. Try again.";
			if(string == "invalid-color") return badPrefix + "Bad colour, defaulted to red.";
			if(string == "invalid-type") return badPrefix + "Bad type, defaulted to creeper.";
			if(string == "firework-spawned") return prefix + "Firework spawned!";
		}
		
		if(CommandBin.language == "dutch") {
			if(string == "enabled") return prefix + "CommandBin is ingeschakeld!";
            if(string == "disabled") return prefix + "CommandBin is uitgeschakeld!";
            if(string == "no-console") return badPrefix + "Je kan deze command niet uitvoeren in console.";
            if(string == "invalid-arguments") return badPrefix + "Je voerde invalide argumenten toe.";
            if(string == "no-permission") return badPrefix + "Je hebt de permissie niet om deze command uit te voeren.";
            if(string == "now-afk") return prefix + "Je bent nu AFK.";
            if(string == "no-afk") return prefix + "Je bent niet langer AFK.";
            if(string == "player-invalid") return badPrefix + "Deze speler is niet online.";
            if(string == "teleport-request-sent") return prefix + "Teleportatie-verzoek is verzonden.";
            if(string == "teleport-request-receive") return prefix + "wil naar je teleporteren.";
            if(string == "teleport-request-receive-2") return prefix + "/tpaccept <speler> of /tpdeny <speler>";
            if(string == "teleport-request-already") return badPrefix + "Je hebt al een teleportatie-verzoek gestuurd naar deze speler.";
            if(string == "teleport-request-accepted") return prefix + "Je teleportatie-verzoek is geaccepteerd. Teleporteren..";
            if(string == "teleport-request-allow") return prefix + "Geaccepteerd. Ogenblikje terwijl ik hen teleporteer..";
            if(string == "teleport-request-invalid") return badPrefix + "Dit teleportatie-verzoek bestaat niet.";
            if(string == "teleport-request-denied") return badPrefix + "Je teleportatie-verzoek is geweigerd.";
            if(string == "teleport-request-deny") return badPrefix + "Teleportatie-verzoek geweigerd.";
            if(string == "player-blocked") return prefix + "Deze speler kan nu geen commands meer gebruiken.";
            if(string == "player-unblocked") return prefix + "Deze speler kan nu terug commands gebruiken.";
            if(string == "blocked-from-commands") return badPrefix + "Je mag geen commands meer gebruiken.";
            if(string == "bolt-striked") return prefix + "Geraakt door een bliksem!";
            if(string == "bolt-player") return prefix + "Speler is neergebliksemd";
            if(string == "bolt-usage") return badPrefix + "/bolt [speler]";
            if(string == "inventory-cleared") return prefix + "Inventory is geleegd.";
            if(string == "exploded") return prefix + "Boom!";
            if(string == "fed-self") return prefix + "Je hebt geen honger meer.";
            if(string == "fed-other") return prefix + "Je hebt speler gevoed. Hij heeft geen honger meer.";
            if(string == "frozen-player") return prefix + "Je hebt deze speler bevroren.";
            if(string == "unfrozen-player") return prefix + "Je hebt deze speler zijn bevriezing weggehaald.";
            if(string == "gamemode-switch") return prefix + "speler's gamemode is veranderd.";
            if(string == "invalid-gamemode") return badPrefix + "Invalide gamemode toegekend.";
            if(string == "player-godmode") return prefix + "Speler heeft nu god-modus.";
            if(string == "player-ungod") return prefix + "Speler heeft niet langer god-modus.";
            if(string == "god-enabled") return prefix + "God-modus ingeschakeld.";
            if(string == "god-disabled") return prefix + "God-modus uitgeschakeld.";
            if(string == "heal-other") return prefix + "Je hebt deze speler genezen.";
            if(string == "heal-self") return prefix + "Je hebt jezelf genezen.";
            if(string == "kill-player") return prefix + "Je hebt deze speler gedood.";
            if(string == "kill-self") return prefix + "Je hebt jezelf gedood.";
            if(string == "invalid-world") return badPrefix + "De wereld die je koos, bestaat niet.";
            if(string == "time-set") return prefix + "Wereldtijd is verzet naar ";
            if(string == "time-locked") return prefix + "De tijd is vastgezet.";
            if(string == "time-unlocked") return prefix + "De tijd gaat terug verder.";
            if(string == "player-muted") return prefix + "Speler is gemuted. Hij kan niet meer praten.";
            if(string == "player-unmuted") return prefix + "Speler is niet meer gemuted. Hij kan terug praten.";
            if(string == "you-are-muted") return badPrefix + "Je kan niet meer praten, je bent gemuted.";
            if(string == "spawn-set") return prefix + "Wereldspawn is naar je locatie verzet.";
            if(string == "spawn-player") return prefix + "Speler geteleporteerd naar spawn in betreffende wereld.";
            if(string == "player-tele-spawn") return prefix + "Geteleporteerd naar je wereldspawn.";
            if(string == "starve-self") return prefix + "Je hebt jezelf uitgehongerd.";
            if(string == "starve-others") return prefix + "Je hebt een andere speler uitgehongerd.";
            if(string == "tele-all") return prefix + "Je hebt alle online spelers naar je toe geteleporteerd.";
            if(string == "players-invalid") return badPrefix + "��n of meerdere spelers hiervan zijn niet online.";
            if(string == "tele-1-2") return prefix + "Speler 1 naar speler 2 geteleporteerd";
            if(string == "invalid-numbers") return badPrefix + "Invalide co�rdinaten ingevoerd.";
            if(string == "tele-1-co") return prefix + "Speler naar de aangegeven co�rdinaten geteleporteerd.";
            if(string == "tele-player") return prefix + "Geteleporteerd naar speler";
            if(string == "player-vanish") return prefix + "Deze speler is nu onzichtbaar.";
            if(string == "player-visible") return prefix + "Deze speler is nu zichtbaar.";
            if(string == "self-invisible") return prefix + "Je bent onzichtbaar.";
            if(string == "self-visible") return prefix + "Je bent niet langer onzichtbaar.";
            if(string == "rain-stopped") return prefix + "Het is nu zonnig.";
            if(string == "rain-start") return prefix + "Het is nu aan het regenen.";
            if(string == "removed-mobs") return prefix + "Alle wezens verwijderd op deze wereld.";
            if(string == "player-fly") return prefix + "Speler kan nu vliegen.";
            if(string == "player-nofly") return prefix + "Speler kan niet langer vliegen.";
            if(string == "fly-self") return prefix + "Je kan nu vliegen.";
            if(string == "nofly-self") return prefix + "Je kan niet langer vliegen.";
            if(string == "chunk-reloaded") return prefix + "De chunk waarin je staat is herladen.";
            if(string == "hat") return prefix + "Je draagt nu een blok-hoed!";
            if(string == "player-bow") return prefix + "Speler kan nu de explosieve boog gebruiken.";
            if(string == "player-nobow") return prefix + "Speler kan de explosieve boog niet meer gebruiken.";
            if(string == "self-bow") return prefix + "Je mag nu de explosieve boog gebruiken, wees voorzichtig.";
            if(string == "self-nobow") return prefix + "Je mag de explosieve boog niet meer gebruiken.";
            if(string == "name-changed") return prefix + "Speler's naam is veranderd!";
			if(string == "chat-cleared") return prefix + "Your chat has been cleared!";
			if(string == "home-set") return prefix + "Your home has been set!";
			if(string == "home-teleport") return prefix + "You have teleported to your home.";
			if(string == "invalid-home") return badPrefix + "You do not have a home! Use /sethome to set one!";
			if(string == "warp-set") return prefix + "Warp has been set!";
			if(string == "warp-teleport") return prefix + "You have teleported to this warp.";
			if(string == "invalid-warp") return badPrefix + "Warp non-existant. Use /setwarp to create one!";
			if(string == "itemname-set")  return prefix + "Item name has been set!";
			if(string == "itemdesc-set")  return prefix + "Item description has been set!";
			if(string == "player-smoke-on") return prefix + "Player will now have smoke whereever they walk.";
			if(string == "player-smoke-off") return prefix + "Player will no longer have smoke.";
			if(string == "self-smoke-on") return prefix + "You will now have smoke where you walk.";
			if(string == "self-smoke-off") return prefix + "You will no longer have smoke.";
			if(string == "warp-list") return prefix + "Warps: {WARPS}";
			if(string == "warp-deleted") return prefix + "Warp has been deleted.";
			if(string == "warp-invalid") return badPrefix + "This warp does not exist.";
			if(string == "mob-spawned") return prefix + "Mob has been spawned!";
			if(string == "invalid-mob") return badPrefix + "The mob you selected does not exist.";
			if(string == "invalid-number") return badPrefix + "Bad number. Try again.";
			if(string == "invalid-color") return badPrefix + "Bad colour, defaulted to red.";
			if(string == "invalid-type") return badPrefix + "Bad type, defaulted to creeper.";
			if(string == "firework-spawned") return prefix + "Firework spawned!";
		}
		return prefix + "Invalid language specified. Report at http://dev.bukkit.org/server-mods/CommandBin";
	}

}
