package com.epam.se01.recursion;

public class Example2 {

    private static void method(int value) {
        System.out.println("Before = " + value--);
        if (value != 0) {
            method(value);
        }
        System.out.println("After = " + value);
    }


    public static void main(String[] args) {
        method(5);
    }
}
