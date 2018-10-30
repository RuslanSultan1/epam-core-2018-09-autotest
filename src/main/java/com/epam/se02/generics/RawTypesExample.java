package com.epam.se02.generics;

public class RawTypesExample {

    public static void main(String[] args) {
//        NumberOptional<Integer> intOptional = new NumberOptional<>(1);
//        NumberOptional<String> stringOptional = new NumberOptional<>("abc");
//
//        NumberOptional rawOptional = intOptional;
//        rawOptional.setValue(new Thread());
//        Object value = rawOptional.getValue();
//
//        Integer intValue = intOptional.getValue();
//
//        System.out.println(value);
    }
}

abstract class MyNumber1 extends Number implements Cloneable, Comparable {

}

abstract class MyNumber2 extends Number implements Cloneable, Comparable {

}

class NumberOptional<T extends Number & Cloneable & Comparable<T>> {

    private T value;

    public NumberOptional(T value) {
        value.compareTo(value);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
