package com.epam.se02.initialization;

public class Example2 {

    static {
        System.out.println("Static-1 (before): " + Example1.staticField);
    }

    static final int staticField;

    static {
        System.out.println("Static-2 (after): " + Example1.staticField);
        staticField = 50;
    }

    {
        System.out.println("Non-static-1 (before): " + this.field);  // 0
    }

    final int field = 55;

    {
        System.out.println("Non-static-2 (after): " + this.field);   // 55
    }

    public Example2(int value) {
        super();
        System.out.println("Constructor: " + field);     // 60
    }
}

class Launcher2 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Before sleep");
        Thread.sleep(5_000);
        System.out.println("After sleep");

        synchronized (Launcher.class) {
            Example1 example1 = new Example1(1000);
            System.out.println(example1.field);  // 1000
        }
    }
}
