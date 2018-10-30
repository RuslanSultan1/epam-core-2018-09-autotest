package com.epam.se02.classes;

import java.util.Date;

public class Example4 {

    public static void main(String[] args) {
        Date realDate = new Date();
        Date anonymousDate = new Date(123) {

            {
                System.out.println("logical block");
            }

            @Override
            public String toString() {
                return "Current time = " + super.toString();
            }

            private void method() {
                System.out.println("Method from anonymous class");
            }
        };


        System.out.println(realDate);
        System.out.println(anonymousDate);

        System.out.println(realDate instanceof Date);
        System.out.println(anonymousDate instanceof Date);

        System.out.println(realDate.getClass() == Date.class);
        System.out.println(anonymousDate.getClass() == Date.class);
        System.out.println(anonymousDate.getClass().getName());

        // ERROR
//        System.out.println(new FinalDate() {
//
//        });
    }
}

final class FinalDate extends Date {

}