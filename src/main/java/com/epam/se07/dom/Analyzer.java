package com.epam.se07.dom;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    public static List<Student> listBuilder(Element root) {
        List<Student> students = new ArrayList<>();
        NodeList studentsNodes = root.getElementsByTagName("student");
        for (int i = 0; i < studentsNodes.getLength(); i++) {
            Element studentElement = (Element) studentsNodes.item(i);
            String faculty = studentElement.getAttribute("faculty");
            String name = getChildValue(studentElement, "name");
            String login = studentElement.getAttribute("login");
            int telephone = Integer.valueOf(getChildValue(studentElement, "telephone"));

            Element addressElement = getChild(studentElement, "address");
            String country = getChildValue(addressElement, "country");
            String city = getChildValue(addressElement, "city");
            String street = getChildValue(addressElement, "street");
            Address address = new Address(country, city, street);

            students.add(new Student(login, name, faculty, telephone, address));
        }
        return students;
    }

    private static String getChildValue(Element parent, String childName) {
        return getChild(parent, childName).getFirstChild().getNodeValue();
    }

    private static Element getChild(Element parent, String childName) {
        return (Element) parent.getElementsByTagName(childName).item(0);
    }
}

