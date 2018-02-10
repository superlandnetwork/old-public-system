//  ___               _                 
// / __|  _  _   ___ | |_   ___   _ __  
// \__ \ | || | (_-< |  _| / -_) | '  \ 
// |___/  \_, | /__/  \__| \___| |_|_|_|
//        |__/                          
//
// Copyright (C) Filli-IT (Einzelunternehmen) & Ursin Filli - All Rights Reserverd
// Unauthorized copying of the this file, via any medium is strictly prohibited
// Proprietary and confidential
// Written by Ursin Filli <ursin.filli@Filli-IT.ch>

package de.superlandnetwork.System.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import de.superlandnetwork.System.Commands.CommandSpy;

public class Command implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onSend(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (!e.isCancelled()) {
			String msg = e.getMessage().split(" ")[0];
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
			if (topic == null) {
				p.sendMessage("§7[§6System§7] §4Unbekannter Befehl!");
				e.setCancelled(true);
			}
		}
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (CommandSpy.PlayersEnable.contains(all)) {
				if (e.getPlayer() != all) {
					all.sendMessage("§cCommandSpy §7: §a[§6" + e.getPlayer().getName() + "§a] §c" + e.getMessage());
				}
			}
		}
	}

}
