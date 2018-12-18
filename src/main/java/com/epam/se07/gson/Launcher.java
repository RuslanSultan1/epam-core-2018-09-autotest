package com.epam.se07.gson;

import com.epam.se07.dom.Address;
import com.epam.se07.dom.Student;
import com.google.gson.Gson;

public class Launcher {

    public static void main(String[] args) {
        Student student = new Student("Ivan007", "Ivan", "ETU", 777, new Address("ru", "spb", "qqq"));

        Gson gson = new Gson();
        String jsonRepresentation = gson.toJson(student);

        System.out.println(jsonRepresentation);

        Student student1 = gson.fromJson(jsonRepresentation, Student.class);

        System.out.println(student == student1);
        System.out.println(student.equals(student1));
        System.out.println(student1);
    }
}
