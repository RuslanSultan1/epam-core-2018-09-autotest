package com.epam.se04;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {

    public static void main(String[] args) {
        try {
            // сериализация
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Object objSave = new Integer(1);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(objSave);

            // смотрим, во что превратился сериализованный объект
            byte[] bArray = os.toByteArray();
            for (byte b : bArray) {
                System.out.print((char) b);
            }
            System.out.println();
            // десериализация
            ByteArrayInputStream is = new ByteArrayInputStream(bArray);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object objRead = ois.readObject();

            Integer deserializedObject = (Integer) objRead;

            System.out.println(objSave.equals(deserializedObject));

            // проверяем идентичность объектов
            System.out.println("readed object is: " + objRead.toString());
            System.out.println("Object equality is: "
                    + (objSave.equals(objRead)));
            System.out
                    .println("Reference equality is: " + (objSave == objRead));
        } catch (NotSerializableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

