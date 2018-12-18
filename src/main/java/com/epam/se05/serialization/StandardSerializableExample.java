package com.epam.se05.serialization;

import lombok.Builder;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
@Builder
class Person implements Serializable {

    private String name;
    private String surname;
    private int age;
}

public class StandardSerializableExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = Person.builder()
                              .name("Ivan")
                              .surname("Alexeev")
                              .age(25)
                              .build();

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes);

        out.writeObject(person);

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()));
        Person deserializedObject = (Person) in.readObject();
        System.out.println(deserializedObject);
        System.out.println("Same object = " + (person == deserializedObject));
    }
}
