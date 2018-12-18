package com.epam.se06.lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void elementNotPresentedInSource() {
        List<Integer> values = Arrays.asList(0, 1, 2, 4, 4, 5, 5, 7, 8);

        int result = BinarySearch.search(values, 6);

        assertEquals(-1, result);
    }

    @Test
    void leftPart() {
        List<Integer> values = Arrays.asList(0, 1, 2, 4, 4, 5, 5, 7, 8);

        int result = BinarySearch.search(values, 1);

        assertEquals(1, result);
    }

    @Test
    void rightPart() {
        List<Integer> values = Arrays.asList(0, 1, 2, 4, 4, 5, 5, 7, 8);

        int result = BinarySearch.search(values, 8);

        assertEquals(8, result);
    }
}