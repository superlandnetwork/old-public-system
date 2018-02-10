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

package de.superlandnetwork.System.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.superlandnetwork.System.Main;

public class Server implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("Forum")) {
			sender.sendMessage("§6---------------[§a SuperLandNetwork.de Forum §6]---------------");
			sender.sendMessage("");
			sender.sendMessage("§a1. §3Du willst uns im Web besuchen?");
			sender.sendMessage("§a2. §3Dort kannst du News, das Team uvm. finden.");
			sender.sendMessage("§a3. §3Klicke auf den Link um auf unser Forum zu kommen");
			sender.sendMessage("§a4. §3Link");
			sender.sendMessage("§a5. §c Forum.SuperLandNetwork.de");
			sender.sendMessage("");
			sender.sendMessage("§6---------------[§a SuperLandNetwork.de Forum §6]---------------");
		}
		if (cmd.getName().equalsIgnoreCase("Webseite")) {
			sender.sendMessage("§6---------------[§a SuperLandNetwork.de Website §6]---------------");
			sender.sendMessage("");
			sender.sendMessage("§a1. §3Du willst uns im Web besuchen?");
			sender.sendMessage("§a2. §3Dort kannst du News, das Team uvm. finden.");
			sender.sendMessage("§a3. §3Klicke auf den Link um auf unsere Seite zu kommen");
			sender.sendMessage("§a4. §3Link");
			sender.sendMessage("§a5. §c SuperLandNetwork.de");
			sender.sendMessage("");
			sender.sendMessage("§6---------------[§a SuperLandNetwork.de Website §6]---------------");
		}
		if (cmd.getName().equalsIgnoreCase("invsee")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (!p.hasPermission("ccl.command.invsee")) {
					return true;
				}
				if (args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null) {
						p.openInventory(t.getInventory());
						return true;
					} else {
						sender.sendMessage("§7[§6System§7] §cDer Spieler ist Offline");
						return true;
					}
				} else {
					sender.sendMessage("§7[§6System§7] §c/invsee §c<Name>");
					return true;
				}
			} else {
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("vanish")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (!p.hasPermission("ccl.command.vanish")) {
					return true;
				}
				if(Main.getInstance().Vanish.contains(p.getUniqueId())) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(all.getUniqueId() != p.getUniqueId()) {
							all.showPlayer(p);
						}
					}
					Main.getInstance().Vanish.remove(p.getUniqueId());
					p.sendMessage("§7[§6System§7] §aDu bist nun wieder sichtbar");
				} else {
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(all.getUniqueId() != p.getUniqueId()) {
							all.hidePlayer(p);
						}
					}
					Main.getInstance().Vanish.add(p.getUniqueId());
					p.sendMessage("§7[§6System§7] §aDu bist nun unsichtbar");
				}
			} else {
				return true;
			}
		}
		return true;
	}

}
