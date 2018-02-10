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

package de.superlandnetwork.System;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.superlandnetwork.System.Commands.ChatClear;
import de.superlandnetwork.System.Commands.CommandSpy;
import de.superlandnetwork.System.Commands.Fly;
import de.superlandnetwork.System.Commands.Gamemode;
import de.superlandnetwork.System.Commands.Heal;
import de.superlandnetwork.System.Commands.Server;
import de.superlandnetwork.System.Commands.Time;
import de.superlandnetwork.System.Listener.Command;
import de.superlandnetwork.System.Listener.Login;
import de.superlandnetwork.System.Listener.Sign;

public class Main extends JavaPlugin {

	public static Main instance;

	public ArrayList<UUID> Vanish = new ArrayList<>();
	
	public boolean BuildServer;

	public void onEnable() {
		instance = this;
		System.out.println("[System] Enabled!");
		registerCommands();
		registerEvents();
	}

	public void onDisable() {
		System.out.println("[System] Disabled!");
	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Command(), this);
		pm.registerEvents(new Login(), this);
		pm.registerEvents(new Sign(), this);
	}

	private void registerCommands() {
		ChatClear ChatClearCMD = new ChatClear();// Perms: ccl.command.ChatClear
		Fly FlyCMD = new Fly();// Perms: ccl.command.fly | ccl.command.fly.other
		Time TimeCMD = new Time();// Perms: ccl.command.day | ccl.command.night
		Heal HealCMD = new Heal();// Perms: ccl.command.heal | ccl.command.heal.other | ccl.command.feed | ccl.command.feed.other
		CommandSpy SPCMD = new CommandSpy();// Perms: ccl.command.CommandSpy
		Server ServerCMD = new Server();// Perms: ccl.command.invsee | ccl.command.vanish
		Gamemode GamemodeCMD = new Gamemode();// Perms: ccl.command.gm | ccl.command.gm.other
		/* ChatClear */
		getCommand("cc").setExecutor(ChatClearCMD);
		getCommand("ChatClear").setExecutor(ChatClearCMD);
		/* Fly */
		getCommand("Fly").setExecutor(FlyCMD);
		/* Time */
		getCommand("night").setExecutor(TimeCMD);
		getCommand("nacht").setExecutor(TimeCMD);
		getCommand("day").setExecutor(TimeCMD);
		getCommand("tag").setExecutor(TimeCMD);
		/* Heal */
		getCommand("heal").setExecutor(HealCMD);
		getCommand("feed").setExecutor(HealCMD);
		/* CommandSpy */
		getCommand("commandspy").setExecutor(SPCMD);
		/* Server */
		getCommand("forum").setExecutor(ServerCMD);
		getCommand("webseite").setExecutor(ServerCMD);
		getCommand("invsee").setExecutor(ServerCMD);
		getCommand("vanish").setExecutor(ServerCMD);

		/* Gamemode */
		getCommand("gm").setExecutor(GamemodeCMD);
		getCommand("gmc").setExecutor(GamemodeCMD);
		getCommand("gms").setExecutor(GamemodeCMD);
		getCommand("gma").setExecutor(GamemodeCMD);
	}

	public static Main getInstance() {
		return instance;
	}

}
