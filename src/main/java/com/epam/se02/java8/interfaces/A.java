package com.epam.se02.java8.interfaces;

interface A {

    default void callMe() {
        System.out.println("A");
    }
}

interface B {

    default void callMe() {
        System.out.println("B");
    }
}

class D {

    void callMe() {
        System.out.println("D");
    }
}

class C extends D implements A, B {

    @Override
    public void callMe() {
        super.callMe();
        A.super.callMe();
        B.super.callMe();
    }
}

class Launcher1 {

    public static void main(String[] args) {
        C c = new C();
        c.callMe();
    }
}
