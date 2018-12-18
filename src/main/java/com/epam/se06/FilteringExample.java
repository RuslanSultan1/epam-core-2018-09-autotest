package com.epam.se06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public class FilteringExample {

    public static void main(String[] args) {
        Collection<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(4);
        values.add(3);
        values.add(2);
//        Collection<Integer> filteredValues = filter(values, value -> value < 4);
//        System.out.println(filteredValues);

        values.removeIf(value -> value < 3);
        System.out.println(values);
    }

    private static <T> Collection<T> filter(Collection<T> source, Predicate<T> condtion) {
        for (Iterator<T> iterator = source.iterator(); iterator.hasNext(); ) {
            if (!condtion.test(iterator.next())) {
                iterator.remove();
//                source.remove(value);
            }
        }
        return source;
    }
}
