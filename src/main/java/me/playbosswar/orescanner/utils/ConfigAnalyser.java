package me.playbosswar.orescanner.utils;

import me.playbosswar.orescanner.Main;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Objects;

public class ConfigAnalyser {
    /**
     * Get all enabled pickaxes
     * @return ArrayList<Material>
     */
    public static ArrayList<Material> getEnabledPickaxes() {
        ArrayList<Material> enabledPickaxes = new ArrayList<>();

        for(String s : Objects.requireNonNull(Main.getPlugin().getConfig().getConfigurationSection("pickaxes")).getKeys(false)) {
            System.out.println(s);
            Material m = Material.matchMaterial(s);
            enabledPickaxes.add(m);
        }
        return enabledPickaxes;
    }
}
