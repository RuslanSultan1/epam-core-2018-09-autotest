package com.epam.se02.generics;

public class Example1 {

    public static void main(String[] args) {
        Queue<Number> numberQueue = new ArrayQueue<Number>();
        numberQueue.put(1);
        Number value = numberQueue.poll();

        // Producer
        // Extends
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        Queue<? extends Number> numberChildQueue1 = integerArrayQueue;

        Number num = 44d;
//        numberChildQueue1.put(num);
//
//        Integer poll = integerArrayQueue.poll();

        // Consumer
        // Super
        Queue<? super Number> numberParentQueue = new ArrayQueue<Number>();
        ArrayQueue<Object> objectArrayQueue = new ArrayQueue<>();
        objectArrayQueue.put("123");
        Queue<? super Number> numberParentQueue2 = objectArrayQueue;
        Object poll = numberParentQueue2.poll();

        numberParentQueue.put(null);
        numberParentQueue.put(1);
        numberParentQueue.put(1d);
        numberParentQueue.put(1f);
        numberParentQueue.put((Number)1f);
    }

    private static Number sum(Queue<? extends Number> queue) {
        double result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll().doubleValue();
        }
        return result;
    }
}
