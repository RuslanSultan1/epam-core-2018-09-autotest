package com.epam.se07.jdom;

import com.epam.se07.dom.Address;
import com.epam.se07.dom.Student;
import org.jdom2.Document;
import org.jdom2.Element;

import java.util.List;
import java.util.stream.Collectors;

public class JDOMAnalyzer {

    public static List<Student> listCreator(Document doc) {
        return doc.getRootElement()
                  .getChildren()
                  .stream()
                  .map(JDOMAnalyzer::parseStudent)
                  .collect(Collectors.toList());
    }

    private static Student parseStudent(Element element) {
        String login = element.getAttributeValue("login");
        String name = element.getChild("name").getText();
        int telephone = Integer.valueOf(element.getChild("telephone").getText());
        String faculty = element.getAttributeValue("faculty");
        Address address = parseAddress(element.getChild("address"));
        return new Student(login, name, faculty, telephone, address);
    }

    private static Address parseAddress(Element element) {
        String country = element.getChild("country").getText();
        String city = element.getChild("city").getText();
        String street = element.getChild("street").getText();
        return new Address(country, city, street);
    }
}

