package me.playbosswar.orescanner.listeners;

import me.playbosswar.orescanner.Main;
import me.playbosswar.orescanner.hooks.VaultAPI;
import me.playbosswar.orescanner.utils.BlockFinder;
import me.playbosswar.orescanner.utils.ConfigAnalyser;
import me.playbosswar.orescanner.utils.Tools;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class PickaxeClickEvents implements Listener {
    private ArrayList<Material> allowedPickaxes = ConfigAnalyser.getEnabledPickaxes();


    @EventHandler
    public void onPickaxeClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        Material inHand = p.getInventory().getItemInMainHand().getType();

        if(VaultAPI.getEconomy().getBalance(p) < 20) {
            p.sendMessage("You don't have enough money to do that");
            return;
        }

        if ((a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) && allowedPickaxes.contains(inHand)) {
            int radius = Main.getPlugin().getConfig().getInt("pickaxes." + inHand + ".radius");
            ArrayList<Material> scanFor = Tools.stringListToMaterialList((ArrayList<String>) Main.getPlugin().getConfig().getStringList("pickaxes." + inHand + ".scanFor"));
            Location blockLocation = BlockFinder.findBlock(p, scanFor, radius);
            if(blockLocation == null) {
                p.sendMessage("Sorry, we couldn't find anything");
                return;
            }

            p.sendMessage("Found a block there");
            p.teleport(BlockFinder.lookAt(p.getLocation(), blockLocation));
        }
    }
}
