package com.epam.se02.java8.interfaces;

@FunctionalInterface
public interface Summator<T> {

    T sum(T left, T right);

    default T twice(T value) {
        return sum(value, value);
    }

    static void method() {
        System.out.println("I'm static from Summator");
    }
}
