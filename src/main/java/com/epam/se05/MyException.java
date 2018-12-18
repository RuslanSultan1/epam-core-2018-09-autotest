package com.epam.se05;

import java.io.IOException;

public class MyException extends RuntimeException {


}

class Laucnher {

    public static void main(String[] args) {
        try {
            method1();
        } catch (RuntimeException ex) {
            Throwable cause = ex.getCause();
            System.out.println(cause instanceof IOException);
        }

    }

    private static void method1() {
        method2();
    }

    private static void method2() {
        IOException cause = new IOException();
        MyException myException = new MyException();
        myException.initCause(cause);
        throw myException;
    }

}
