package com.epam.se03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringBuilderTest {

    public static final int DEFAULT_CAPACITY_BUILDER = 16;

    @Test
    void capacityVsLength() {
        StringBuilder builder = new StringBuilder("abc");

        assertEquals(3, builder.length());
        assertEquals(DEFAULT_CAPACITY_BUILDER + 3, builder.capacity());

        builder.append("12345678901234567");
        assertEquals(20, builder.length());
        assertEquals(40, builder.capacity());

        builder.setLength(0);
        assertEquals(0, builder.length());
        assertEquals(40, builder.capacity());

        builder.append("123");
        builder.trimToSize();
        assertEquals(3, builder.length());
        assertEquals(3, builder.capacity());
    }

    @Test
    void setLength() {
        StringBuilder builder = new StringBuilder("123");

        builder.setLength(2);

        assertEquals("12", builder.toString());

        builder.setLength(4);
        assertEquals("12\0\0", builder.toString());

        builder.setLength(0);
        assertEquals("", builder.toString());
        assertEquals(0, builder.length());
    }
}
