package com.etaTech;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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
        int x;
        int y;
        try {
            x = getInt();
            y = getInt();
            return x / y;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No Suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Cant divide By Zero");
        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Exception : " + e.getMessage());
                System.out.println("Enter Number 0:9");
            }
        }
    }
}