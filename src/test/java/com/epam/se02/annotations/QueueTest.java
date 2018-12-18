package com.epam.se02.annotations;

import com.epam.se02.generics.ArrayQueue;
import com.epam.se02.generics.Queue;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueTest {

    @Test
    void test1() {
        Queue<String> queue = new ArrayQueue<>();

        assertTrue(queue.isEmpty());
    }

    @Test
    void test2() {
        Queue<String> queue = new ArrayQueue<>();

        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }

    @Test
    void test3() {
        Queue queue = new ArrayQueue();

        assertThrows(NoSuchElementException.class, () -> queue.poll());
    }

    @Test
    void test4() {
        Queue<Integer> queue = new ArrayQueue<>();

        int value = 1;
        queue.put(value);
        Object result = queue.peek();

        assertFalse(queue.isEmpty());
        assertEquals(value, result);
    }

    @Test
    void test5() {
        Queue<Integer> queue = new ArrayQueue<>();

        int value = 1;
        queue.put(value);
        Object result = queue.poll();

        assertTrue(queue.isEmpty());
        assertEquals(value, result);
    }

    @Test
    void test6() {
        Queue<Integer> queue = new ArrayQueue<>();

        int value1 = 1;
        int value2 = 2;
        queue.put(value1);
        queue.put(value2);
        Object result1 = queue.poll();
        Object result2 = queue.poll();

        assertEquals(value1, result1);
        assertEquals(value2, result2);
        assertTrue(queue.isEmpty());
    }

    @Test
    void test7() {
        Queue<String> queue = new ArrayQueue<>();

        String str = "123";
        queue.put(str);
        String result = queue.poll();

        assertEquals(3, result.length());
        assertTrue(queue.isEmpty());
    }

    @Test
    void test8() {
        Queue<String> stringQueue = new ArrayQueue<>();

        String str = "123";
        stringQueue.put(str);

        devilMethod(stringQueue);

        assertThrows(ClassCastException.class, () -> stringQueue.poll());
    }

    private void devilMethod(Queue queue) {
        queue.poll();
        queue.put(1);
    }
}