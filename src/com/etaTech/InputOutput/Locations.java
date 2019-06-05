package com.etaTech.InputOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/****************************************************
 *** Created by Fady Fouad on 6/5/2019 at 12:32.***
 ***************************************************/
public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location>locationMap = new HashMap<>();

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Location.txt");
            for (Location location :
                    locationMap.values()) {
                fileWriter.write("Location ID : "+location.getLocationID()+ " , Location Desc : "+location.getDesc()+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static {
        Map<String ,Integer>tempExit = new HashMap<>();
        locationMap.put(0, new Location(0, "Out Of Game",tempExit));
        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locationMap.put(1, new Location(1, "room 1",tempExit));
        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locationMap.put(2, new Location(2, "room 2",tempExit));
        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locationMap.put(3, new Location(3, "room 3",tempExit));
        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locationMap.put(4, new Location(4, "room 4",tempExit));
        locationMap.put(5, new Location(5, "room 4+",tempExit));
        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locationMap.put(5, new Location(5, "room 5",tempExit));
    }

    @Override
    public int size() {
        return locationMap.size();
    }

    @Override
    public boolean isEmpty() {
        return locationMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locationMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locationMap.containsKey(value);
    }

    @Override
    public Location get(Object key) {
        return locationMap.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locationMap.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locationMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {



    }

    @Override
    public void clear() {

        locationMap.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locationMap.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locationMap.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locationMap.entrySet();
    }
}