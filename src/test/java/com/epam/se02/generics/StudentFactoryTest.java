package com.epam.se02.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    void usingAnonymosClass() {
        StudentFactory factory = new StudentFactory() {
            @Override
            public Student create(int weight, int age, String name, int course) {
                return new Student(weight, age, name, course);
            }
        };

        assertEquals(new Student(50, 24, "A", 3), factory.create(50, 24, "A", 3));
    }

    @Test
    void usingLambda() {
        StudentFactory factory = (weight, age, name, course) -> new Student(weight, age, name, course);

        assertEquals(new Student(50, 24, "A", 3), factory.create(50, 24, "A", 3));
    }

    @Test
    void usingConstructorReference() {
        StudentFactory factory = Student::new;

        assertEquals(new Student(50, 24, "A", 3), factory.create(50, 24, "A", 3));
    }
}