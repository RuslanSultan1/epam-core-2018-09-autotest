package com.epam.se02.inheritance.example5;

class A {

    long getValue() {
        return 10;
    }

    Number getNumber() {
        return 10;
    }
}

class B extends A {

    @Override
    long getValue() {
        return 3;
    }

    @Override
    Double getNumber() {
        return 3d;
    }
}


class Launcher {
    public static void main(String[] args) {
        A a = new B();
        Number number = a.getNumber();
        System.out.println(number);

        B b = new B();
        Double doubleValue = b.getNumber();


        Object str = "123";
        b = (B)str;
    }
}

