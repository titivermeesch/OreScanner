package me.playbosswar.orescanner.utils;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Tools {
    public static ArrayList<Material> stringListToMaterialList(ArrayList<String> materials) {
        ArrayList<Material> newMaterials = new ArrayList<>();
        for(String material : materials) {
            newMaterials.add(Material.matchMaterial(material));
        }
        return newMaterials;
    }
}
