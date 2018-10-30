package com.epam.se02.generics;

import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example2 {

    private static List<Person> createPeople() {
        return Arrays.asList(
                new Person(70, 20, "Ivan"),
                new Person(50, 16, "Alex"),
                new Person(60, 25, "Helen")
        );
    }

    private static List<Student> createStudents() {
        return Arrays.asList(
                new Student(70, 20, "Ivan", 6),
                new Student(50, 16, "Alex", -1),
                new Student(60, 25, "Helen", 6)
        );
    }

    public static void main(String[] args) {
        List<Student> objects = createStudents();

        System.out.println(objects);
        sort(objects, new ObjectByHashCodeComparator());
        System.out.println(objects);
    }

    private static void sort(List<? extends Person> people, Comparator<? super Person> comparator) {
        people.sort(comparator);
    }
}

class PersonByAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class PhysicalObjectByWeightComparator implements Comparator<PhysicalObject> {

    @Override
    public int compare(PhysicalObject o1, PhysicalObject o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}

class ObjectByHashCodeComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}

@EqualsAndHashCode
class PhysicalObject {

    private int weight;

    public PhysicalObject(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PhysicalObject{" +
                "weight=" + weight +
                '}';
    }
}

@EqualsAndHashCode(callSuper = true)
class Person extends PhysicalObject {

    private int age;
    private String name;

    public Person(int weight, int age, String name) {
        super(weight);
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "weight=" + getWeight() +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@EqualsAndHashCode(callSuper = true)
class Student extends Person {

    private int course;

    public Student(int weight, int age, String name, int course) {
        super(weight, age, name);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}