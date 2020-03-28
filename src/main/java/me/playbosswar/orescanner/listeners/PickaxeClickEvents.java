package me.playbosswar.orescanner.listeners;

import me.playbosswar.orescanner.utils.ConfigAnalyser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class PickaxeClickEvents implements Listener {
    public static ArrayList<Material> allowedPickaxes = ConfigAnalyser.getEnabledPickaxes();

    @EventHandler
    public void onPickaxeClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if ((a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) && allowedPickaxes.contains(p.getInventory().getItemInMainHand().getType())) {
            p.sendMessage("Player interact event with stone pickaxe");
        }
    }
}
