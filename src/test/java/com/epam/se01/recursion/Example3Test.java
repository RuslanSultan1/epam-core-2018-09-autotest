package com.epam.se01.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Example3Test {


    @Test
    void test1() {
        long result = Example3.reverse(156);

        assertEquals(651, result);
    }
}