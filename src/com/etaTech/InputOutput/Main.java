package com.etaTech.InputOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/****************************************************
 *** Created by Fady Fouad on 5/9/2019 at 4:44 PM.***
 ***************************************************/
public class Main {
    private static Map<Integer, Location> locationMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("\n============================= Adventure =========================\n");
        Scanner scanner = new Scanner(System.in);

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


        Map<String ,String> vocap = new HashMap();
        vocap.put("QUIT","Q");
        vocap.put("WEST","W");
        vocap.put("EAST","E");
        vocap.put("SOUTH","S");
        vocap.put("NORTH","N");

        int location = 1;
        while (true) {
            System.out.println(locationMap.get(location).getDesc());
            if (location == 0) {
                break;
            }
            Map<String, Integer> exits = new HashMap(locationMap.get(location).getExits());

            for (String exit :
                    exits.keySet()) {
                System.out.println(exit + " -> " + " " + locationMap.get(exits.get(exit)).getDesc());
            }
            String dir = scanner.nextLine().toUpperCase();
            if (dir.length()>1){
                String[] words = dir.split(" ");
                for (String word:
                     words) {
                    if (vocap.containsKey(word)){
                        dir = vocap.get(word);
                        break;
                    }
                }
            }
            if (exits.containsKey(dir)) {
                location = exits.get(dir);
            } else {
                System.out.println("You Cannt Go There");
            }
            if (!locationMap.containsKey(location)) {
                System.out.println("Location Not Available");
                break;
            }
        }

    }
}