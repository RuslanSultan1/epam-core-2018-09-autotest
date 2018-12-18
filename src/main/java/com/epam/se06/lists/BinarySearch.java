package com.epam.se06.lists;

import java.util.List;

public class BinarySearch {

    // search([0, 1, 2, 4, 4, 5, 5, 7, 8], 6)
    // [0, 1, 2, 4, 4, 5, 5, 7, 8]
    // [               5, 5, 7, 8]
    // [                     7, 8]
    // [                   ^     ]
    static <T extends Comparable<T>> int search(List<? extends T> data, T element) {
        for (int start = 0, end = data.size(), mid; start < end; ) {
            mid = start + (end - start) / 2;

            int resultComparing = element.compareTo(data.get(mid));
            if (resultComparing == 0) {
                return mid;
            } else if (resultComparing < 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
