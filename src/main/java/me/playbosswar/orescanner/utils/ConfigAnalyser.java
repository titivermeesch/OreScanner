package me.playbosswar.orescanner.utils;

import me.playbosswar.orescanner.Main;
import org.bukkit.Material;

import java.util.ArrayList;

public class ConfigAnalyser {
    /**
     * Get all enabled pickaxes
     * @return ArrayList<Material>
     */
    public static ArrayList<Material> getEnabledPickaxes() {
        ArrayList<Material> enabledPickaxes = new ArrayList<>();

        for(String s : Main.getPlugin().getConfig().getConfigurationSection("pickaxes").getKeys(false)) {
            Material m = Material.valueOf(s);
            enabledPickaxes.add(m);
        }
        return enabledPickaxes;
    }
}
