package me.playbosswar.orescanner.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {
    public static String transformColor(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static void sendConsoleMessage(String s) {
        Bukkit.getConsoleSender().sendMessage(transformColor("&a[OreScanner] " + s));
    }

    public static void sendPlayerMessage(Player p, String s) {
        p.sendMessage(transformColor("&a[OreScanner] " + s));
    }
}
