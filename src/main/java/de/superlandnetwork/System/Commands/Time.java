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

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("day") || cmd.getName().equalsIgnoreCase("tag")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (!p.hasPermission("ccl.command.day")) {
					return true;
				}
				p.getWorld().setTime(0L);
				p.sendMessage("§7[§6System§7] §aEs ist nun Tag!");
				return true;
			}
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("night") || cmd.getName().equalsIgnoreCase("nacht")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (!p.hasPermission("ccl.command.night")) {
					return true;
				}
				p.getWorld().setTime(20000L);
				p.sendMessage("§7[§6System§7] §aEs ist nun Nacht!");
				return true;
			}
			return true;
		}
		return true;
	}

}
