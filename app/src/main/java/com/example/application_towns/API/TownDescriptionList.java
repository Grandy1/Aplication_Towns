package com.example.application_towns.API;

import java.util.ArrayList;
import java.util.List;

public class TownDescriptionList {
    public static List<String> townsList = new ArrayList<>();

    public void setString(String town) {
        townsList.add(town);
    }

    public String[] getStringArray() {
        String[] towns = new String[townsList.size()];
        int i = 0;
        for (String town : townsList) {
            towns[i++] = town;
        }
        return towns;
    }

}
