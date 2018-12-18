package com.epam.se06.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListIterator<Integer> iterator = values.listIterator();

        System.out.println(iterator.nextIndex());
        iterator.add(-1);
        iterator.add(-2);
        iterator.add(-3);
        System.out.println(values);

    }
}
