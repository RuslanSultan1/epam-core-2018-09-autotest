package com.epam.se02.finalize;

public class Example1 {

    static Example1 zombie;

    @Override
    protected void finalize() {
        zombie = this;
    }
}

class Launcher {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10_000);


        Example1 ref = new Example1();

        System.out.println(ref.toString());

        ref = null;

        Runtime.getRuntime().gc();

        System.out.println(ref);


        Thread.sleep(5_000);
        System.out.println(Example1.zombie);
    }
}
