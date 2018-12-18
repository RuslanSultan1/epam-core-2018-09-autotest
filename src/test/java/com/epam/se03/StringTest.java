package com.epam.se03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringTest {

    @Test
    void indexOfForString() {
        String original = "12345671";
        int result = original.indexOf('1');
        assertEquals(0, result);
        assertEquals(7, original.indexOf('1', result + 1));
        assertEquals(1, original.indexOf("234"));
    }

    @Test
    void trimTest() {
        assertEquals("", "".trim());
        assertEquals("1 2", " 1 2 ".replace('\u00A0', ' ').trim());
        assertEquals("", "\r\n".trim());
        assertEquals("12      34", "12      34".trim());
        assertEquals("12      34", " 12      34    ".trim());
        assertEquals("12      34", " 12      34\t\r\n ".trim());
    }

    @Test
    void matches() {
        String input = "12321,2323";

        assertTrue(input.matches("^\\d+,\\d+$"));
    }

    @Test
    void split() {
        String input = "123,2, 3,  4, 5";

        String[] parts = input.split(", *");

        System.out.println(Arrays.toString(parts));

        assertArrayEquals(new String[]{"123", "2", "3", "4", "5"}, parts);
    }

    @Test
    void splitWithLimit() {
        String input = "123,2, 3,  4, 5";

        String[] parts = input.split(", *", 4);

        assertArrayEquals(new String[]{"123", "2", "3", "4, 5"}, parts);
    }

    @Test
    void splitStar() {
        String input = "1,2";

        String[] parts = input.split(",");

        System.out.println(Arrays.toString(parts));

        assertArrayEquals(new String[]{"1", "2"}, parts);
    }

    @Test
    void parseNull() {
        Object ref = null;

        assertEquals("null", String.valueOf(ref));
//        assertEquals("null", ref.toString()); NPE
    }
}
