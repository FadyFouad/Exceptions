package com.etaTech;

import java.util.Scanner;

/****************************************************
 *** Created by Fady Fouad on 6/4/2019 at 14:29.***
 ***************************************************/
public class EXExample {
    public static void main(String[] args) {
        int results = divide();
        System.out.println(results);
    }

    private static int divide() {
        int x = getInt();
        int y = getInt();
        return x/y;
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter int");
        return scanner.nextInt();
    }
}