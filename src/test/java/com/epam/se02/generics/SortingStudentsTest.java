package com.epam.se02.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ComparatorCombinators")
class SortingStudentsTest {

    @Test
    void name() {
        List<Student> students = Arrays.asList(
                new Student(50, 24, "A", 3),
                new Student(60, 26, "B", 3),
                new Student(75, 22, "C", 1),
                new Student(45, 21, "D", 2)
        );

        ArrayList<Student> result = new ArrayList<>(students);
        result.sort((student1, student2) -> Integer.compare(student1.getWeight(), student2.getWeight()));

        assertEquals(Arrays.asList(students.get(3), students.get(0), students.get(1), students.get(2)), result);
    }


}