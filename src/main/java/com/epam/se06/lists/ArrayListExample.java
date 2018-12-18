package com.epam.se06.lists;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    /**
     * O(1)         size()
     * O(1) ~ O(n)  contains(E)
     * O(1)         get(index)
     * O(1)         set(index, E)     [1, 2, 3, 4].set(1, 5) → [1, 5, 3, 4]
     * O(n)         remove(E)         ["1", "2", "3", "4"].remove("5") → false
     * O(1) ~ O(n)  remove(index)
     * O(1)         add(E)
     * O(1) ~ O(n)  add(index, E)     [1, 2, 3, 4].add(5, 2) → [1, 2, 5, 3, 4]
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> strings = new ArrayList<>();
        // []
        strings.add("1");

        // ["1"]
        strings.add("2");

        // ["1", "3"]
        strings.add("3");

        // ["1", "3", "hello"]
        strings.add("hello");

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes);

        out.writeObject(strings);

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()));
        List object = (List) in.readObject();
        System.out.println(object);

        strings.trimToSize();

        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.remove(Integer.valueOf(2));
    }
}
