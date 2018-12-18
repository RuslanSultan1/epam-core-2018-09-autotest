package com.epam.se06.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Example1 {

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(1);
        values.add(1);
        values.add(1);

        List<Integer> subList = values.subList(1, 3);

        ListIterator<Integer> iterator = subList.listIterator();
        System.out.println(iterator.previousIndex());
        while (iterator.hasNext()) {
            iterator.next();
            iterator.set(2);
        }

        System.out.println(subList);
        System.out.println(values);

        subList.add(1, 3);
        System.out.println(values);
    }
}
