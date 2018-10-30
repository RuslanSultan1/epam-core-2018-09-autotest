package com.epam.se02.classes;

import com.epam.se02.generics.Queue;

import java.util.ArrayList;
import java.util.Iterator;

public class Example1 {

    public static void main(String[] args) {
        queue();
    }

    private static void queue() {
        Queue<String> queue = new LinkedQueue<>();
        queue.put("a");
        queue.put("b");
        queue.put("c");

        Iterator<String> iterator = queue.iterator();

        queue.poll();

        System.out.println(iterator.next());
    }
}
