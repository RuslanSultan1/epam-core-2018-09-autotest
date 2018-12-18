package com.epam.se04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("file.out");

        System.setOut(new PrintStream(fileOutputStream));

        System.out.println("Hello, world!");
    }
}
