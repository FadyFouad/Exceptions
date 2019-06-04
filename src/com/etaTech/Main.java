package com.etaTech;

public class Main {

    public static void main(String[] args) {
        System.out.println("-----------------------EXCEPTIONS----------------------------");

        System.out.println(divideLBYL(10,0));
        System.out.println(divideEAFP(10,0));
        System.out.println(divide(10,0));

    }
    private static int divideLBYL(int x , int y){
        if(y!=0){
            return x/y ;
        }
        else
            return 0;
    }
    private static int divideEAFP(int x , int y){
        try {
            return x/y;
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    private static int divide(int x , int y){
            return x/y;
    }
}
