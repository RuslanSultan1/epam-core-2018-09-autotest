package com.epam.se02.classes;

import com.epam.se02.generics.Queue;

import java.util.NoSuchElementException;

public class QueueTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    private static void test1() {
        Queue<String> queue = new LinkedQueue<>();

        assert queue.isEmpty();

        System.out.println("Test1 passed");
    }

    private static void test2() {
        Queue<String> queue = new LinkedQueue<>();

        try {
            String value = queue.peek();
            assert false;
        } catch (Exception ex) {
            assert ex instanceof NoSuchElementException;
        }

        System.out.println("Test2 passed");
    }

    private static void test3() {
        Queue queue = new LinkedQueue();

        try {
            queue.poll();
            assert false;
        } catch (Exception ex) {
            assert ex instanceof NoSuchElementException;
        }

        System.out.println("Test3 passed");
    }

    private static void test4() {
        // prepare
        Queue<Integer> queue = new LinkedQueue<>();

        // run
        int value = 1;
        queue.put(value);
        Object result = queue.peek();

        // asserts
        assert result.equals(value);
        assert !queue.isEmpty();

        System.out.println("Test4 passed");
    }

    private static void test5() {
        Queue<Integer> queue = new LinkedQueue<>();

        int value = 1;
        queue.put(value);
        Object result = queue.poll();

        assert result.equals(value);
        assert queue.isEmpty();

        System.out.println("Test5 passed");
    }

    private static void test6() {
        Queue<Integer> queue = new LinkedQueue<>();

        int value1 = 1;
        int value2 = 2;
        queue.put(value1);
        queue.put(value2);
        Object result1 = queue.poll();
        Object result2 = queue.poll();

        assert result1.equals(value1);
        assert result2.equals(value2);
        assert queue.isEmpty();

        System.out.println("Test6 passed");
    }

    private static void test7() {
        Queue<String> queue = new LinkedQueue<>();

        String str = "123";
        queue.put(str);
        String result = (String) queue.poll();

        assert result.length() == 3;
        assert queue.isEmpty();

        System.out.println("Test7 passed");
    }

    private static void test8() {
        Queue<String> stringQueue = new LinkedQueue<>();

        String str = "123";
        stringQueue.put(str);

        devilMethod(stringQueue);

        String result = stringQueue.poll();

        assert result.length() == 3;
        assert stringQueue.isEmpty();

        System.out.println("Test8 passed");
    }

    private static void devilMethod(Queue<String> queue) {
        queue.poll();
//        queue.put(1);
    }

    private static void test9() {
        Queue<String> stringQueue = new LinkedQueue<>();

        isEmpty(stringQueue);

        Queue<Integer> intQueue = new LinkedQueue<>();
        isEmpty(intQueue);
    }

    private static boolean isEmpty(Queue<?> queue) {

//        queue.put("123");
//        queue.put(1);
//        queue.put(new Thread());
//        queue.put(new Object());
        queue.put(null);

        Object poll = queue.poll();

        return queue.isEmpty();
    }
}







