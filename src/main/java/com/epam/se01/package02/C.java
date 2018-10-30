package com.epam.se01.package02;

import com.epam.se01.package01.A;

public class C extends A {

    public static void main(String[] args) {
        System.out.println(A.publicField);
        System.out.println(A.protectedField);
//        System.out.println(A.FIELD);
//        System.out.println(A.privateField);
    }
}
