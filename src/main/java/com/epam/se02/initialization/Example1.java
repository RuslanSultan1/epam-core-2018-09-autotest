package com.epam.se02.initialization;

public class Example1 {

    static {
        System.out.println("Static-1 (before): " + Example1.staticField);
    }

    static int staticField = 42;

    static {
        System.out.println("Static-2 (after): " + Example1.staticField);
        staticField = 50;
    }

    {
        System.out.println("Non-static-1 (before): " + this.field);  // 0
    }

    int field = 55;

    {
        System.out.println("Non-static-2 (after): " + this.field);   // 55
        field = 60;
    }

    public Example1(int value) {
        super();
        System.out.println("Constructor: " + field);     // 60
        field = value;
    }
}

class Launcher {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Before sleep");
        Thread.sleep(5_000);
        System.out.println("After sleep");

        Example1 example1 = new Example1(1000);
        System.out.println(example1.field);  // 1000
    }
}
