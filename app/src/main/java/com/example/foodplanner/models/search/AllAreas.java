package com.example.foodplanner.models.search;

import com.example.foodplanner.R;
public class AllAreas {
    private static AllAreas allAreas=null;
    private  Area[] areas;

    private AllAreas() {
        areas= new Area[]{
                new Area("American", R.drawable.america),
                new Area("British", R.drawable.british),
                new Area("Canadian", R.drawable.canada),
                new Area("Chinese", R.drawable.china),
                new Area("Croatian", R.drawable.croatian),
                new Area("Dutch", R.drawable.dutch),
                new Area("Egyptian", R.drawable.egypt),
                new Area("French", R.drawable.french),
                new Area("Greek", R.drawable.greek),
                new Area("Indian", R.drawable.indian),
                new Area("Irish", R.drawable.ireland),
                new Area("Italian", R.drawable.italian),
                new Area("Jamaican", R.drawable.jamaican),
                new Area("Japanese", R.drawable.japan),
                new Area("Kenyan", R.drawable.kenya),
                new Area("Malaysian", R.drawable.malaysian),
                new Area("Mexican", R.drawable.mexico),
                new Area("Moroccan", R.drawable.moroco),
                new Area("Polish", R.drawable.poland),
                new Area("Portuguese", R.drawable.portug),
                new Area("Russian", R.drawable.russian),
                new Area("Spanish", R.drawable.spani),
                new Area("Thai", R.drawable.thia),
                new Area("Tunisian", R.drawable.tunisian),
                new Area("Turkish", R.drawable.turcia),
                new Area("Unknown", R.drawable.unknown),
                new Area("Vietnamese", R.drawable.vietname)
        };
    }

    public static AllAreas getInstance() {
        if (allAreas == null) {
            allAreas = new AllAreas();
        }

        return allAreas;
    }
    public Area[] getAllAreas() {
        return areas;
    }
}
