package com.example.foodplanner.models.search;

import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;

public class AllAreas {
    private static AllAreas allAreas=null;
    private  List<Area> areas= new  ArrayList<Area>();

    private AllAreas() {
        areas.add(new Area("American", R.drawable.america));
        areas.add(new Area("British", R.drawable.british));
        areas.add(new Area("Canadian", R.drawable.canada));
        areas.add(new Area("Chinese", R.drawable.china));
        areas.add(new Area("Croatian", R.drawable.croatian));
        areas.add(new Area("Dutch", R.drawable.dutch));
        areas.add(new Area("Egyptian", R.drawable.egypt));
        areas.add(new Area("French", R.drawable.french));
        areas.add(new Area("Greek", R.drawable.greek));
        areas.add(new Area("Indian", R.drawable.indian));
        areas.add(new Area("Irish", R.drawable.ireland));
        areas.add(new Area("Italian", R.drawable.italian));
        areas.add(new Area("Jamaican", R.drawable.jamaican));
        areas.add(new Area("Japanese", R.drawable.japan));
        areas.add(new Area("Kenyan", R.drawable.kenya));
        areas.add(new Area("Malaysian", R.drawable.malaysian));
        areas.add(new Area("Mexican", R.drawable.mexico));
        areas.add(new Area("Moroccan", R.drawable.moroco));
        areas.add(new Area("Polish", R.drawable.poland));
        areas.add(new Area("Portuguese", R.drawable.portug));
        areas.add(new Area("Russian", R.drawable.russian));
        areas.add(new Area("Spanish", R.drawable.spani));
        areas.add(new Area("Thai", R.drawable.thia));
        areas.add(new Area("Tunisian", R.drawable.tunisian));
        areas.add(new Area("Turkish", R.drawable.turcia));
        areas.add(new Area("Unknown", R.drawable.unknown));
        areas.add(new Area("Vietnamese", R.drawable.vietname));



    }

    public static AllAreas getInstance() {
        if (allAreas == null) {
            allAreas = new AllAreas();
        }

        return allAreas;
    }
    public List<Area> getAllAreas() {
        return areas;
    }
}
