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

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

import de.superlandnetwork.API.PlayerAPI.PermAPI;
import de.superlandnetwork.API.PlayerAPI.PermEnum;
import de.superlandnetwork.API.PlayerAPI.PlayerAPI;
import de.superlandnetwork.System.Main;

public class Login implements Listener {

	@EventHandler(ignoreCancelled=true)
	public void PlayerLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		PlayerAPI api = new PlayerAPI(p.getUniqueId());
		api.InsertUserInDB();
		int Group_ID = api.getPlayerGroup();
		PermissionAttachment attachment = p.addAttachment(Main.getInstance());
		for (String Perms : PermAPI.getGroupPermisonsOrdet(Group_ID)) {
			attachment.setPermission(Perms, true);
		}
	}
	
	@EventHandler(ignoreCancelled=true)
	public void PlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		PlayerAPI api = new PlayerAPI(p.getUniqueId());
		if(!Main.getInstance().Vanish.isEmpty()) {
			for (UUID uuid : Main.getInstance().Vanish) {
				p.hidePlayer(Bukkit.getPlayer(uuid));
			}
		}
		if(api.IsPlayerInGroup(PermEnum.ADMINISTRATOR.getId()) || api.IsPlayerInGroup(PermEnum.ADMINISTRATORIN.getId()) || api.IsPlayerInGroup(PermEnum.OWNER.getId()) || api.IsPlayerInGroup(PermEnum.OWNERIN.getId())) {
			p.setOp(true);
		} else {
			if (Bukkit.getPluginManager().isPluginEnabled("BuildServer")) {
				if(!api.IsPlayerInGroup(PermEnum.SRMODERATOR.getId()) && !api.IsPlayerInGroup(PermEnum.SRMODERATORIN.getId())) {
					if(!api.IsPlayerInGroup(PermEnum.BUILDER.getId()) && !api.IsPlayerInGroup(PermEnum.BUILDERIN.getId())) {
						p.setOp(false);
					}
				}
			} else {
				p.setOp(false);
			}
		}
	}
	
	@EventHandler(ignoreCancelled=true)
	public void PlayerLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(Main.getInstance().Vanish.contains(p.getUniqueId())) {
			Main.getInstance().Vanish.remove(p.getUniqueId());
		}
	}

}
