package com.epam.se01.recursion;

public class Example3 {

    // 153
    // 351

    // 76474700000
    // 747467
    public static long reverse(long value) {
        return Long.parseLong(new StringBuilder(String.valueOf(value)).reverse().toString());
    }
}
