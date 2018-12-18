package com.epam.se05.serialization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ExternalizabePerson implements Externalizable {

    private transient String name;
    private String surname;
    private int age;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal called");
        out.writeObject(name);
        out.writeObject(surname);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal called");
        name = (String) in.readObject();
        surname = (String) in.readObject();
        age = in.readInt();
    }
}

public class StandardExternalizableExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizabePerson person = ExternalizabePerson.builder()
                                                        .name("Ivan")
                                                        .surname("Alexeev")
                                                        .age(25)
                                                        .build();

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes);

        out.writeObject(person);

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()));
        ExternalizabePerson deserializedObject = (ExternalizabePerson) in.readObject();
        System.out.println(deserializedObject);
        System.out.println("Same object = " + (person == deserializedObject));
    }
}
