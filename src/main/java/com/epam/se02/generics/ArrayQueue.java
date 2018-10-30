package com.epam.se02.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

    private static final int INITIAL_CAPACITY = 16;
    private Object[] data = new Object[INITIAL_CAPACITY];
    private int indexPut = 0;
    private int indexPoll = 0;

    // [_ _ _ _]
    //  ^
    //  $

    // put(5)

    // [_ _ 4 7]
    //          ^
    //      $

    @Override
    public void put(E value) {
        if (indexPut == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[indexPut++] = value;
    }

    // [_ 2 3 4 5 _ _ _ ]
    //    $       ^

    @Override
    @SuppressWarnings("unchecked")
    public E poll() throws NoSuchElementException {
        checkNotEmpty();
        Object result = data[indexPoll++];
        if (indexPoll == data.length / 2) {
            Object[] tmp = new Object[data.length / 2];
            System.arraycopy(data, indexPoll, tmp, 0, tmp.length);
            indexPoll = 0;
            indexPut -= tmp.length;
            data = tmp;
        }
        return (E) result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() throws NoSuchElementException {
        checkNotEmpty();
        return (E) data[indexPoll];
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean isEmpty() {
        return indexPoll == indexPut;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
