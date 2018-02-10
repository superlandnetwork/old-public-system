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
import de.superlandnetwork.API.PlayerAPI.PlayerAPI;

public class ChatClear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("cc") || cmd.getName().equalsIgnoreCase("ChatClear")) {
			if (!sender.hasPermission("ccl.command.ChatClear")) {
				return true;
			}

			/* ChatClear */
			for(int i = 0; i < 256; i++) {
				API.getInstance().sendMessageToAllPlayers(" ");
			}

			if (sender instanceof Player)
				Bukkit.broadcastMessage("§7[§6System§7] §cDer Chat wurde von §c"
						+ new PlayerAPI(((Player) sender).getUniqueId()).getChatPrefix() + " §cGecleart");
			else
				Bukkit.broadcastMessage("§7[§6System§7] §cDer Chat wurde von §c" + sender.getName() + " §cgecleart");
		}
		return true;
	}

}
