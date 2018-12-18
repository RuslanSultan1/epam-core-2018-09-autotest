package com.epam.se07.stax;

public class StAXStudentMain {

    public static void main(String[] args) {
        new StAXStudentParser().parse(StAXStudentMain.class.getResourceAsStream("students.xml"));
    }
}

