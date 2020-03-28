package me.playbosswar.orescanner;

import me.playbosswar.orescanner.listeners.PickaxeClickEvents;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Plugin p;

    @Override
    public void onEnable() {
        p = this;
        getServer().getPluginManager().registerEvents(new PickaxeClickEvents(), this);
        saveDefaultConfig();
        getConfig().options().copyDefaults(false);
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        p = null;
    }

    public static Plugin getPlugin() {
        return p;
    }
}
