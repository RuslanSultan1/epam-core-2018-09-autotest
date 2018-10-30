package com.epam.se02.inheritance;

public class Example1 {

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getField());
    }
}

class A {

    static {
        System.out.println("A::static block");
    }

    {
        System.out.println("A::logical block (1) " + this.field);
    }

    int field = 42;


    public int getField() {
        return field;
    }

    public A() {
        super();
        System.out.println("A::constructor");
    }


    {
        System.out.println("A::logical block (2) " + this.field);
    }

}

class B extends A {

    static {
        System.out.println("B::static block");
    }

    {
        System.out.println("B::logical block: " + field);
    }

    public B() {
        super();
        System.out.println("B::constructor");
    }

    public void doSmth() {
//        System.out.println(FIELD);
    }
}