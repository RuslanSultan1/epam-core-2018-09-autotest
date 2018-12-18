package com.epam.se03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void createStudent() {
        Student result = Student.builder()
                                .name("Ivan")
                                .age(26)
                                .surname("Ivanov")
                                .build();

        Student a = new Student(1, "a", "2");

        assertEquals(26, result.getAge());
    }
}