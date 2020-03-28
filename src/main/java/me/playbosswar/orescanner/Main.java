package me.playbosswar.orescanner;

import me.playbosswar.orescanner.commands.HelpCommands;
import me.playbosswar.orescanner.hooks.VaultAPI;
import me.playbosswar.orescanner.listeners.PickaxeClickEvents;
import me.playbosswar.orescanner.utils.Messages;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Plugin p;

    @Override
    public void onEnable() {
        p = this;
        Messages.sendConsoleMessage("Loading OreScanner, please wait...!!!");
        getServer().getPluginManager().registerEvents(new PickaxeClickEvents(), this);
        getCommand("oretest").setExecutor(new HelpCommands());
        saveDefaultConfig();
        getConfig().options().copyDefaults(false);
        if(VaultAPI.hasVaultInstalled()) {
            VaultAPI.hookVaultProvider();
            Messages.sendConsoleMessage("Vault is available and has been hooked into OreScanner");
        }
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
