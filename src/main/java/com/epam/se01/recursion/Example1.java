package com.epam.se01.recursion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Example1 {

    private int field;

    // -Xss5m
    void method() {
        System.out.println("Before = " + field--);
        if (field != 0) {
            method2();
        }
        System.out.println("After = " + field);
    }

    void method2() {
        method();
    }
}

class Launcher {

    public static void main(String[] args) {
        Example1 example1 = new Example1(5);
        example1.method();
    }
}
