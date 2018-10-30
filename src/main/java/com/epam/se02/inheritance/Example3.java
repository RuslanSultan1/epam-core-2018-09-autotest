package com.epam.se02.inheritance;

public class Example3 {

    public static void main(String[] args) {
//        Object c = new D();
//        ((C)c).saySmth();

        E c = new E();
        c.staticSaySmth();
    }
}


class C {

    private int value = 42;

    public void saySmth() {
        System.out.println("C");
    }

    public static void staticSaySmth() {
        System.out.println("C::static");
    }
}

class D extends C {

    @Override
    public void saySmth() {
        System.out.println("D");
    }

    public static void staticSaySmth() {
        System.out.println("D::static");
    }
}

class E extends D {

    @Override
    public void saySmth() {
        System.out.println("E");
    }

}