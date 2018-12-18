package com.epam.se04;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        String input = "1  b    3 \n4 5 a 4 6";

        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt() + 1);
            } else {
                System.out.println(scanner.next());
            }
        }



    }
}
