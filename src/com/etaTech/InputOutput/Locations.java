package com.etaTech.InputOutput;

import java.io.*;
import java.util.*;

/****************************************************
 *** Created by Fady Fouad on 6/5/2019 at 12:32.***
 ***************************************************/
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locationMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        //TODO JAVA 8 try with resources
        try (BufferedWriter fileWriter =new BufferedWriter(new FileWriter("Location.txt"));
             BufferedWriter fileDirections =new BufferedWriter(new FileWriter("Directions.txt"))) {
            for (
                    Location location :
                    locationMap.values()) {
                fileWriter.write(location.getLocationID() + "," + location.getDesc() + "\n");
                for (String dir :
                        location.getExits().keySet()) {
                    fileDirections.write(location.getLocationID() + "," + dir + "," + location.getExits().get(dir) + "\n");
                }
            }
        }
    }


    static {
        //TODO Read Fromm File
//        Scanner scanner = null;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {

            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String desc = scanner.nextLine();
                System.out.println(desc);
                Map<String, Integer> map = new HashMap<>();
                locationMap.put(loc, new Location(loc, desc, map));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try (BufferedReader scanner = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while ((input = scanner.readLine())!=null) {
                String[]data = input.split(",");
                String dest = data[2];
                int loc = Integer.parseInt(data[0]);
                String dir = data[1];
                int destenation = Integer.parseInt(dest);
                System.out.println(loc + "," + dir + "," + destenation);
                Location location = locationMap.get(loc);
                location.addExit(dir, destenation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return locationMap.put(key, value);
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