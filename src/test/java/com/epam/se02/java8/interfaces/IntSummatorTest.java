package com.epam.se02.java8.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntSummatorTest {

    @DisplayName("Test sum method")
    @Test
    void test1() {
        IntSummator summator = new IntSummator();

        Integer result = summator.sum(1, 2);

        assertEquals(3, result.intValue());
    }

    @DisplayName("Test sum twice method")
    @Test
    void test2() {
        IntSummator summator = new IntSummator();

        Integer result = summator.twice(1);

        assertEquals(2, result.intValue());
    }
}