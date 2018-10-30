package com.epam.se02.annotations;

import com.epam.se02.generics.ArrayQueue;
import com.epam.se02.generics.Queue;

import java.util.NoSuchElementException;

public class QueueTest {

    @Test
    public void test1() {
        Queue<String> queue = new ArrayQueue<>();

        assert queue.isEmpty();
    }

    @Test
    public void test2() {
        Queue<String> queue = new ArrayQueue<>();

        try {
            String value = queue.peek();
            assert false;
        } catch (Exception ex) {
            assert ex instanceof NoSuchElementException;
        }
    }

    @Test
    public void test3() {
        Queue queue = new ArrayQueue();

        try {
            queue.poll();
            assert false;
        } catch (Exception ex) {
            assert ex instanceof NoSuchElementException;
        }
    }

    public void test4() {
        // prepare
        Queue<Integer> queue = new ArrayQueue<>();

        // run
        int value = 1;
        queue.put(value);
        Object result = queue.peek();

        // asserts
        assert result.equals(value);
        assert !queue.isEmpty();
    }

    @Test
    public void test5() {
        Queue<Integer> queue = new ArrayQueue<>();

        int value = 1;
        queue.put(value);
        Object result = queue.poll();

        assert result.equals(value);
        assert queue.isEmpty();
    }

    @Test
    public void test6() {
        Queue<Integer> queue = new ArrayQueue<>();

        int value1 = 1;
        int value2 = 2;
        queue.put(value1);
        queue.put(value2);
        Object result1 = queue.poll();
        Object result2 = queue.poll();

        assert result1.equals(value1);
        assert result2.equals(value2);
        assert queue.isEmpty();
    }

    @Test
    public void test7() {
        Queue<String> queue = new ArrayQueue<>();

        String str = "123";
        queue.put(str);
        String result = (String) queue.poll();

        assert result.length() == 3;
        assert queue.isEmpty();
    }

    @Test
    public void test8() {
        Queue<String> stringQueue = new ArrayQueue<>();

        String str = "123";
        stringQueue.put(str);

        devilMethod(stringQueue);

        String result = stringQueue.poll();

        assert result.length() == 3;
        assert stringQueue.isEmpty();
    }

    public void devilMethod(Queue queue) {
        queue.poll();
        queue.put(1);
    }
}
