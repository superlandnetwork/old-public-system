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

import de.superlandnetwork.API.API;

public class Fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fly")) {
			if (!sender.hasPermission("ccl.command.fly")) {
				return true;
			}
			if(!API.getInstance().AllowFlyCommand) {
				sender.sendMessage("§7[§6System§7] §cDer /fly command wurde Deaktiviert!");
				return true;
			}
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
						
					if (p.getAllowFlight()) {
						p.setAllowFlight(false);
						sender.sendMessage("§7[§6System§7] §cFliegen §cDeaktiviert!");
						return true;
					} else {
						p.setAllowFlight(true);
						sender.sendMessage("§7[§6System§7] §aFliegen §aAktiviert!");
						return true;
					}
				} else {
					sender.sendMessage("§7[§6System§7] §c/Fly §c<Name>");
					return true;
				}
			} else if (args.length == 1) {
				if (!sender.hasPermission("ccl.command.fly.other")) {
					return true;
				}
				
				Player t = Bukkit.getPlayer(args[0]);
				if (t == null) {
					sender.sendMessage("§7[§6System§7] §cDer §cSpieler §cist §cOffline!");
					return true;
				}
				if (t.getAllowFlight()) {
					t.setAllowFlight(false);
					t.sendMessage("§7[§6System§7] §cFliegen §cDeaktiviert!");
					sender.sendMessage("§7[§6System§7] §cFliegen §cvon §6" + args[0] + " §cDeaktiviert!");
					return true;
				} else {
					t.setAllowFlight(true);
					t.sendMessage("§7[§6System§7] §aFliegen §aAktiviert!");
					sender.sendMessage("§7[§6System§7] §aFliegen §avon §6" + args[0] + " §aAktiviert!");
					return true;
				}
			} else {
				sender.sendMessage("§7[§6System§7] §c/Fly §c(Name)");
				return true;
			}
		}
		return true;
	}

}
