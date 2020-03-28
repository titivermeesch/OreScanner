package me.playbosswar.orescanner.hooks;

import me.playbosswar.orescanner.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultAPI {
    private static Economy eco;
    /**
     * Check if Vault is installed
     * @return boolean value representing if yes or no Vault is installed
     */
    public static boolean hasVaultInstalled() {
        return Main.getPlugin().getServer().getPluginManager().getPlugin("Vault") != null;
    }

    /**
     * Get installed Vault instance
     * @return VaultAPI instance
     */
    public static void hookVaultProvider() {
        RegisteredServiceProvider<Economy> rsp = Main.getPlugin().getServer().getServicesManager().getRegistration(Economy.class);

        assert rsp != null;
        eco = rsp.getProvider();
    }

    public static Economy getEconomy() {
        return eco;
    }
}
