package com.epam.se04;

import lombok.Value;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class SerializableExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student(24, "Ivan", "Ivanov");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(student);

        byte[] bytes = out.toByteArray();
        System.out.println(new String(bytes));

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Student deserializedStudent = (Student) objectInputStream.readObject();

        System.out.println(student == deserializedStudent);
        System.out.println(student.equals(deserializedStudent));
    }

    public static class Student implements Serializable {
        transient int age;
        String name;
        String surname;

        public Student(int age, String name, String surname) {
            this.age = age;
            this.name = name;
            this.surname = surname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(name, student.name) &&
                    Objects.equals(surname, student.surname);
        }

        @Override
        public int hashCode() {

            return Objects.hash(age, name, surname);
        }
    }
}
