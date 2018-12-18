package com.epam.se04.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class A implements Serializable  {

    private static final long serialVersionUID = 2L;

    private int field;
    private int field2;
    private String str;

    public A(int field, String str) {
        this.field = field;
        this.str = str;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "A{" +
                "field=" + field +
                ", str='" + str + '\'' +
                '}';
    }
}

class Launcher {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A object = new A(42, "abc");
//        System.out.println(object);

//        String file = "./../a.dat";
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
//            out.writeObject(object);
//        }


        InputStream resourceStream = Launcher.class.getResourceAsStream("/b.dat");
        System.out.println(resourceStream);
        try (ObjectInputStream in = new ObjectInputStream(resourceStream)) {
            A deserializedObject = (A) in.readObject();
            System.out.println(deserializedObject.getField());
            System.out.println(deserializedObject.getStr());
            System.out.println(deserializedObject);
        }
    }
}
