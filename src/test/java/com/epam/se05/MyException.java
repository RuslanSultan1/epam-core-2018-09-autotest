package com.epam.se05;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("TryWithIdenticalCatches")
public class MyException {


    @Test
    void test1() {
        throw new UnsupportedOperationException();

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Before try");
        try {
//            method1();
            method2();
            method3();
            System.out.println("After all");
        } catch (NullPointerException ex) {
            System.out.println("Catch");
            throw ex;
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("IOException");
        } catch (Exception ex) {
            System.out.println("Exception");
        } catch (Throwable ex) {
            System.out.println("Throwable");
            throw ex;
        } finally {
//            System.out.println("Finally");
        }
        System.out.println("After try");
    }

    private static void method1() {
        System.out.println("Method1");
    }

    private static void method2() throws FileNotFoundException {
        try {
            FileNotFoundException exception = new FileNotFoundException();
            System.out.println("some text");
            throw exception;
        } catch (IllegalStateException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        System.out.println("Method2");
    }

    private static void method3() {
        System.out.println("Method3");
    }
}
