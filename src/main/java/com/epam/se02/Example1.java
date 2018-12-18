package com.epam.se02;

@SuppressWarnings("all")
public class Example1 {

    public Example1() {
    }

    public static void main(String[] args) {

        final int a = 42;
//        a = 45;
        final StringBuilder builder = new StringBuilder();
//        builder = null;
        builder.append('1');


        Number val = 40;
        method((Integer)val);

    }

//    static int method() {
//        System.out.println("int");
//        return 1;
//    }

    static void method(Object ref) {
        System.out.println("void");
    }

    static void method(Integer val) {
        System.out.println("Val");
    }

    static void method(int val) {
        System.out.println("Val");
    }

    static void method1() {

    }
}
