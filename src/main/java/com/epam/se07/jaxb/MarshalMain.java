package com.epam.se07.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MarshalMain {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Student.Address addr = new Student.Address("BLR", "Minsk", "Skoriny 4");
            Student student = new Student("mendig", "Dmitry Terenya", "rfe", 2066394, addr);// объект

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            marshaller.marshal(student, out);
            marshaller.marshal(student, System.out);// на консоль

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object obj = unmarshaller.unmarshal(new ByteArrayInputStream(out.toByteArray()));
            Student unmarshalledObject = (Student) obj;

            System.out.println(student.equals(unmarshalledObject));
        } catch (JAXBException e) {
            System.out.println("JAXB-исключения");
            e.printStackTrace();
        }
    }
}

