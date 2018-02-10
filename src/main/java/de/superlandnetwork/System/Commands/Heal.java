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

public class Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("heal")) {
			if (args.length == 0) {
				if (!sender.hasPermission("ccl.command.heal")) {
					return true;
				}
				if(!API.getInstance().AllowHealCommand) {
					sender.sendMessage("§7[§6System§7] §cDer /heal command wurde Deaktiviert!");
					return true;
				}
				if (sender instanceof Player) {
					Player p = (Player) sender;
					p.setHealth(20D);
					p.setFoodLevel(20);
					p.sendMessage("§7[§6System§7] §aDu hast  dich Geheilt!");
					return true;
				}
			}
			if (args.length == 1) {
				if (!sender.hasPermission("ccl.command.heal.other")) {
					return true;
				}
				if(!API.getInstance().AllowHealCommand) {
					sender.sendMessage("§7[§6System§7] §cDer /heal command wurde Deaktiviert!");
					return true;
				}
				Player t = Bukkit.getPlayer(args[0]);
				if (t != null) {
					t.setHealth(20D);
					t.setFoodLevel(20);
					t.sendMessage("§7[§6System§7] §aDu wurdest Geheilt!");
					sender.sendMessage("§7[§6System§7] §aDu hast §6" + args[0] + " §a Geheilt!");
					return true;
				}
				sender.sendMessage("§7[§6System§7] §cDer Spieler ist Offline");
				return true;
			}
			sender.sendMessage("§7[§6System§7] §c/heal (Name)");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("feed")) {
			if (args.length == 0) {
				if (!sender.hasPermission("ccl.command.feed")) {
					return true;
				}
				if(!API.getInstance().AllowHealCommand) {
					sender.sendMessage("§7[§6System§7] §cDer /feed command wurde Deaktiviert!");
					return true;
				}
				if (sender instanceof Player) {
					Player p = (Player) sender;
					p.setHealth(20D);
					p.setFoodLevel(20);
					p.sendMessage("§7[§6System§7] §aDu hast deine Hungerleiste aufgefühlt!");
					return true;
				}
			}
			if (args.length == 1) {
				if (!sender.hasPermission("ccl.command.feed.other")) {
					return true;
				}
				if(!API.getInstance().AllowHealCommand) {
					sender.sendMessage("§7[§6System§7] §cDer /feed command wurde Deaktiviert!");
					return true;
				}
				Player t = Bukkit.getPlayer(args[0]);
				if (t != null) {
					t.setHealth(20D);
					t.setFoodLevel(20);
					t.sendMessage("§7[§6System§7] §aDeine Hungerleiste wurde aufgefühlt!");
					sender.sendMessage("§7[§6System§7] §aDu hast die Hungerleiste von §6" + args[0]
							+ " §a Aufgefühlt!");
					return true;
				}
				sender.sendMessage("§7[§6System§7] §cDer Spieler ist Offline");
				return true;
			}
			sender.sendMessage("§7[§6System§7] §c/feed (Name)");
			return true;
		}
		return true;
	}

}
