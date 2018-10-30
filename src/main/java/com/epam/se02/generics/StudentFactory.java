package com.epam.se02.generics;

@FunctionalInterface
public interface StudentFactory {

    Student create(int weight, int age, String name, int course);
}
