package com.epam.se07.dom;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class DOMMain {

    public static void main(String[] args) {
        try {
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = parser.parse(DOMMain.class.getResourceAsStream("../students.xml"));
            List<Student> students = Analyzer.listBuilder(document.getDocumentElement());
            students.forEach(System.out::println);
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.print("ошибка SAX парсера");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.print("ошибка конфигурации");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("ошибка I/О потока");
        }
    }
}

