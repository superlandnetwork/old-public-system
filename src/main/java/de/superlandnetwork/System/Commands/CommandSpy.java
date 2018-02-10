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

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpy implements CommandExecutor {

	public static List<Player> PlayersEnable = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("commandspy")) {
			if (!(sender instanceof Player))
				return true;
			Player p = (Player) sender;
			if (!p.hasPermission("ccl.command.CommandSpy")) {
				return true;
			}
			if (PlayersEnable.contains(p)) {
				PlayersEnable.remove(p);
				sender.sendMessage("§cCommandSpy Disabled");
			} else {
				PlayersEnable.add(p);
				sender.sendMessage("§aCommandSpy Enabled");
			}
			return true;
		}
		return true;
	}

}
