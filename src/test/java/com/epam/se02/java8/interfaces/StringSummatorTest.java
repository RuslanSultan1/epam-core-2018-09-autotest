package com.epam.se02.java8.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSummatorTest {

    @DisplayName("Test sum method")
    @Test
    void test1() {
        Summator<String> summator = String::concat;

        String result = summator.sum("a", "b");

        assertEquals("ab", result);
    }

    @DisplayName("Test sum twice method")
    @Test
    void test2() {
        Summator<String> summator = StringSummatorTest::concat;

        summator.sum("a", "b");

        String result = summator.twice("a");

        assertEquals("aa", result);
    }

    private static String concat(String left, String right) {
        return left + right;
    }
}