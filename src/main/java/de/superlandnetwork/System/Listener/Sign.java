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

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class Sign implements Listener {

	@EventHandler
	public void OnFarbigeSignChange(SignChangeEvent e) {
		String Lineie0 = e.getLine(0);
		String Lineie1 = e.getLine(1);
		String Lineie2 = e.getLine(2);
		String Lineie3 = e.getLine(3);
		String trans0 = ChatColor.translateAlternateColorCodes('&', Lineie0);
		String trans1 = ChatColor.translateAlternateColorCodes('&', Lineie1);
		String trans2 = ChatColor.translateAlternateColorCodes('&', Lineie2);
		String trans3 = ChatColor.translateAlternateColorCodes('&', Lineie3);
		e.setLine(0, trans0);
		e.setLine(1, trans1);
		e.setLine(2, trans2);
		e.setLine(3, trans3);
	}

}
