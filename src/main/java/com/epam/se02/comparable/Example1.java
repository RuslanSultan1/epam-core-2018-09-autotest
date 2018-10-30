package com.epam.se02.comparable;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Example1 {

    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("5z", "t", 1),
                new Student("3t", "t", 4),
                new Student("1n", "n", 10),
                new Student("2e", "e", 7),
        };

        System.out.println("Before: " + Arrays.toString(students));

        Arrays.sort(students);

        System.out.println("After: " + Arrays.toString(students));

        Arrays.sort(students, new StudentBySurnameComparator());

        System.out.println("After using comparator " + Arrays.toString(students));

//        Arrays.sort(students, new SurnameNameComparator());

        Arrays.sort(students, new StudentByNameComparator());
        Arrays.sort(students, new StudentBySurnameComparator());

        System.out.println("SurnameName: " + Arrays.toString(students));

        // 1 2 3 1 2 3 2 3 4
        // 1 1 2 2 2 3 3 3 4

        // {1, D} {2, B} {3, C} {3, A} {1, A}

        // {1, D} {1, A} {2, B} {3, C} {3, A}

        // {1, D} {1, A} {2, B} {3, C} {3, A}

        // {1, A} {3, A} {2, B} {3, C} {1, D}

        Arrays.sort(students, comparing(Student::getSurname).thenComparing(Student::getName));
    }
}

class StudentBySurnameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}

class StudentByNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SurnameNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getSurname().compareTo(o2.getSurname());
        if (result == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}

