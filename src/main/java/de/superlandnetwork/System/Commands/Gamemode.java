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
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.superlandnetwork.API.API;

public class Gamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (!sender.hasPermission("ccl.command.gm")) {
				return true;
			}
			if(!API.getInstance().AllowGamemodeCommand) {
				sender.sendMessage("§7[§6System§7] §cDer §c/gm §cCommand §cwurde §cDeaktiviert!");
				return true;
			}
			if (args.length == 1) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (args[0].equalsIgnoreCase("0")) {
						// Gamemode: 0 (Survival)
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§7[§6System§7] §aDu §abist §anun §ain §agm §a0!");
						return true;
					}
					if (args[0].equalsIgnoreCase("1")) {
						// Gamemode: 1 (Creative)
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§7[§6System§7] §aDu §abist §anun §ain §agm §a1!");
						return true;
					}
					if (args[0].equalsIgnoreCase("2")) {
						// Gamemode: 2 (Adventure)
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage("§7[§6System§7] §aDu §abist §anun §ain §agm §a2!");
						return true;
					}
					if (args[0].equalsIgnoreCase("3")) {
						// Gamemode: 3 (Spectator)
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§7[§6System§7] §aDu §abist §anun §ain §agm §a3!");
						return true;
					}
					sender.sendMessage("§7[§6System§7] §c/gm §c<0/1/2/3> §c(Name)");
					return true;
				}
				return true;
			} else if (args.length == 2) {
				Player p = Bukkit.getPlayer(args[1]);
				if (!sender.hasPermission("ccl.command.gm.other")) {
					return true;
				}
				if (p != null) {
					if (args[0].equalsIgnoreCase("0")) {
						// Gamemode: 0 (Survival)
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§7[§6System§7] §aDu §abist §anun §ain §agm §a0!");
						sender.sendMessage("§7[§6System§7] §aDu hast §c" + args[1] + "§a GM 0 gesetzt!");
						return true;
					}
					if (args[0].equalsIgnoreCase("1")) {
						// Gamemode: 1 (Creative)
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§7[§6System§7] §aDu bist nun in gm 1!");
						sender.sendMessage("§7[§6System§7] §aDu hast §c" + args[1] + "§a GM 1 gesetzt!");
						return true;
					}
					if (args[0].equalsIgnoreCase("2")) {
						// Gamemode: 2 (Adventure)
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage("§7[§6System§7] §aDu bist nun in gm 2!");
						sender.sendMessage("§7[§6System§7] §aDu hast §c" + args[1] + "§a GM 2 gesetzt!");
						return true;
					}
					if (args[0].equalsIgnoreCase("3")) {
						// Gamemode: 3 (Spectator)
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§7[§6System§7] §aDu bist nun in gm 3!");
						sender.sendMessage("§7[§6System§7] §aDu hast §c" + args[1] + "§a GM 3 gesetzt!");
						return true;
					}
					sender.sendMessage("§7[§6System§7] §c/gm <0/1/2/3> (Name)");
					return true;
				}
				sender.sendMessage("§7[§6System§7]§cFehler: Der Spieler §a" + args[1] + " §c Ist nicht Online!");
				return true;
			}
			sender.sendMessage("§7[§6System§7] §c/gm <0/1/2/3> (Name)");
			return true;
		}
		// GMC
		if (cmd.getName().equalsIgnoreCase("gmc")) {
			if (!sender.hasPermission("ccl.command.gm")) {
				return true;
			}
			if(!API.getInstance().AllowGamemodeCommand) {
				sender.sendMessage("§7[§6System§7] §cDer /gmc command wurde Deaktiviert!");
				return true;
			}
			if (args.length == 0) {
				if (!(sender instanceof Player))
					return true;
				// Gamemode: 1 (Creative)
				Player p = (Player) sender;
				p.setGameMode(GameMode.CREATIVE);
				sender.sendMessage("§7[§6System§7] §aDu bist nun in gm 1!");
				return true;
			}
			if (args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if (!sender.hasPermission("ccl.command.gm.other")) {
					return true;
				}
				if (t == null) {
					sender.sendMessage("§7[§6System§7] Der Spieler §a" + args[1] + " §c Ist nicht Online!");
					return true;
				}
				// Gamemode: 1 (Creative)
				t.setGameMode(GameMode.CREATIVE);
				t.sendMessage("§7[§6System§7] §aDu bist nun in gm 1!");
				sender.sendMessage("§7[§6System§7] §aDu hast §c" + args[1] + "§a GM 1 gesetzt!");
				return true;
			}
			sender.sendMessage("§7[§6System§7] §c/gmc (Name)");
			return true;
		}
		// GMS
		if (cmd.getName().equalsIgnoreCase("gms")) {
			if (!sender.hasPermission("ccl.command.gm")) {
				return true;
			}
			if(!API.getInstance().AllowGamemodeCommand) {
				sender.sendMessage("§7[§6System§7] §cDer /gms command wurde Deaktiviert!");
				return true;
			}
			if (args.length == 0) {
				if (!(sender instanceof Player))
					return true;
				// Gamemode: 0 (Survival)
				Player p = (Player) sender;
				p.setGameMode(GameMode.SURVIVAL);
				sender.sendMessage("§7[§6System§7] §aDu bist nun in gm 0!");
				return true;
			}
			if (args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if (!sender.hasPermission("ccl.command.gm.other")) {
					return true;
				}
				if (t == null) {
					sender.sendMessage("§7[§6System§7] Der Spieler §a" + args[1] + " §c Ist nicht Online!");
					return true;
				}
				// Gamemode: 0 (Survival)
				t.setGameMode(GameMode.SURVIVAL);
				t.sendMessage("§7[§6System§7] §aDu bist nun in gm 0!");
				sender.sendMessage("§7[§6System§7] §aDu hast §c" + args[1] + "§a GM 0 gesetzt!");
				return true;
			}
			sender.sendMessage("§7[§6System§7] §c/gms (Name)");
			return true;
		}
		// GMA
		if (cmd.getName().equalsIgnoreCase("gma")) {
			if (!sender.hasPermission("ccl.command.gm")) {
				return true;
			}
			if(!API.getInstance().AllowGamemodeCommand) {
				sender.sendMessage("§7[§6System§7] §cDer /gma command wurde Deaktiviert!");
				return true;
			}
			if (args.length == 0) {
				if (!(sender instanceof Player)) 
					return true;
				// Gamemode: 2 (Adventure)
				Player p = (Player) sender;
				p.setGameMode(GameMode.ADVENTURE);
				sender.sendMessage("§7[§6System§7] §aDu bist nun in gm 2!");
				return true;
			}
			if (args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if (!sender.hasPermission("ccl.command.gm.other")) {
					return true;
				}
				if (t == null) {
					sender.sendMessage("§7[§6System§7] Der Spieler §a" + args[1] + " §c Ist nicht Online!");
					return true;
				}
				// Gamemode: 2 (Adventure)
				t.setGameMode(GameMode.ADVENTURE);
				t.sendMessage("§7[§6System§7] §aDu bist nun in gm 2!");
				sender.sendMessage("§7[§6System§7] §aDu hast §c" + args[1] + "§a GM 2 gesetzt!");
				return true;
			}
			sender.sendMessage("§7[§6System§7] §c/gma (Name)");
			return true;
		}
		return true;
	}

}
