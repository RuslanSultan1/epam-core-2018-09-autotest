package com.epam.se05;

public class CustomExceptionHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            System.out.println("Exception " + ex + " thrown in thread " + thread);
        });


        method1();
    }

    private static void method1() {
        method2();
    }

    private static void method2() {
        throw new UnsupportedOperationException();
    }
}
