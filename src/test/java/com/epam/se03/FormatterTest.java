package com.epam.se03;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {

    @Test
    void name() {
//        PrintStream out = System.out;
//        out.printf("%s", "Hello, world");

        boolean b1 = true;
        Boolean b2 = null;
        System.out.println("1. - " + b1 + ", " + b2);
        System.out.printf("2. - %2$b, %1$b%n", b1, b2);
        System.out.printf("3. - %b, %b%n", b1, b2);
        System.out.printf("4. - %b, %b, %b%n", b1, b2, b2);
        System.out.printf("5. - %b, %b, %<b%n", b1, b2);
    }

    @Test
    void flagsTest() {
        Formatter formatter = new Formatter();
        formatter.format("%#X %#o %+d %+d", 10, 7, 50, -50);

        String result = formatter.toString();

        assertEquals("0XA 07 +50 -50", result);
    }

    @Test
    void spacesTest() {
        Formatter formatter = new Formatter();
        formatter.format("%- 4d,%( 06d", 50, -50);

        assertEquals(" 50 ,(0050)", formatter.toString());
    }

    @Test
    void precision() {
        Formatter formatter = new Formatter();
        formatter.format("%.2f", 5.555556);

        assertEquals("5.56", formatter.toString());
    }

    @Test
    void time() {
        Formatter formatter = new Formatter();
        formatter.format("%tH %<tl", new Date(1541176056526L));

        assertEquals("19 7", formatter.toString());
    }
}
