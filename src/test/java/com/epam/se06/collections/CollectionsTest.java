package com.epam.se06.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparingInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CollectionsTest {

    @Test
    void fillOnEmptyList() {
        List<String> list = new ArrayList<>();

        Collections.fill(list, "hello");

        assertTrue(list.isEmpty());
    }

    @Test
    void fillOnNotEmptyList() {
        List<String> list = Arrays.asList("1", "2", "3");

        Collections.fill(list, "hello");

        assertEquals(3, list.size());
        assertEquals("hello", list.get(0));
        assertEquals("hello", list.get(1));
        assertEquals("hello", list.get(2));

        assertEquals(Arrays.asList("hello", "hello", "hello"), list);
    }

    @Test
    void copyLists() {
        List<String> src = Arrays.asList("1", "2", "3");
        List<String> dst = Arrays.asList("2", "3", "1", "4");

        Collections.copy(dst, src);

        assertEquals(Arrays.asList("1", "2", "3", "4"), dst);
    }

    @Test
    void minUsingNaturalOrder() {
//        Set<String> values = Set.of("abc", "cde", "1"); // Java9+ API
        Set<String> values = new HashSet<>(Arrays.asList("abc", "cde", "1234", "q"));
//        values.add("abc");
//        values.add("cde");
//        values.add("1");

        String result = Collections.min(values);

        assertEquals("1234", result);
    }

    @Test
    void minUsingCustomOrder() {
        Set<String> values = new HashSet<>(Arrays.asList("abc", "cde", "1234", "q"));

        String result = Collections.min(values, comparingInt(String::length));

        assertEquals("q", result);
    }

    @Test
    void rotateRight() {
        List<String> list = Arrays.asList("1", "2", "3");

        Collections.rotate(list, 2);

        assertEquals(Arrays.asList("2", "3", "1"), list);
    }

    @Test
    void rotateLeft() {
        List<String> list = Arrays.asList("1", "2", "3");

        Collections.rotate(list, -2);

        assertEquals(Arrays.asList("3", "1", "2"), list);
    }

    @Test
    void indexOfSubList() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 2, 2, 3);

        int result = Collections.indexOfSubList(values, Arrays.asList(2, 3));

        assertEquals(1, result);
    }

    @Test
    void lastIndexOfSubList() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 2, 2, 3);

        int result = Collections.lastIndexOfSubList(values, Arrays.asList(2, 3));

        assertEquals(6, result);
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void unmodifiableCollection() {
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 2, 3));

        List<Integer> unmodifiable = Collections.unmodifiableList(values);

        assertThrows(UnsupportedOperationException.class, () -> unmodifiable.add(1));
    }

    @Test
    @SuppressWarnings("all")
    void checkedCollection() {
        // PECS
        List<Number> list = new ArrayList<>();

        List<Number> checked = Collections.checkedList(list, Number.class);

        List raw = checked;

        raw.add(1);
        assertThrows(ClassCastException.class, () -> raw.add("c"));
    }

    @Test
    void reverseOrder() {
        List<Integer> values = Arrays.asList(1, 3, 6, 2, 4, 3);

        values.sort(Collections.reverseOrder());

        assertEquals(Arrays.asList(6, 4, 3, 3, 2, 1), values);
    }
}
