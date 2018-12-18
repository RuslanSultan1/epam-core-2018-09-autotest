package com.epam.se03.localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatExample {

    public static void main(String[] args) {
        Locale[] locales = {Locale.getDefault(), new Locale("no", "NO"), Locale.JAPAN};


        NumberFormat[] numFormatters = new NumberFormat[]{
                NumberFormat.getNumberInstance(),
                NumberFormat.getNumberInstance(locales[1]),
                NumberFormat.getNumberInstance(locales[2])
        };

        NumberFormat[] currFormatters = new NumberFormat[]{
                NumberFormat.getCurrencyInstance(),
                NumberFormat.getCurrencyInstance(locales[1]),
                NumberFormat.getCurrencyInstance(locales[2])
        };

        double number = 9876.598;
        System.out.println("Formatting the number: " + number);
        runFormatters(number, numFormatters, locales);

        for (NumberFormat nf : numFormatters) {
            nf.setMaximumFractionDigits(2);
        }

        System.out.println("\nFormatting the number " + number + " (to 2 dec. places: ");
        runFormatters(number, numFormatters, locales);

        System.out.println("\nFormatting the currency amount: " + number);
        runFormatters(number, currFormatters, locales);

        runParsers("9876.598", numFormatters, locales);
        runParsers("9876,598", numFormatters, locales);
        runParsers("9876@598", numFormatters, locales);
        runParsers("@9876598", numFormatters, locales);
        runParsers("£9876.598", currFormatters, locales);
        runParsers("kr 9876,598", currFormatters, locales);
        runParsers("JPY 98@76598", currFormatters, locales);
        runParsers("@9876598", currFormatters, locales);
    }

    static void runFormatters(double value, NumberFormat[] formatters, Locale[] locales) {
        for (int i = 0; i < formatters.length; i++) {
            System.out.printf("%-24s: %s%n", locales[i].getDisplayName(), formatters[i].format(value));
        }
    }

    static void runParsers(String inputString, NumberFormat[] formatters, Locale[] locales) {
        System.out.println("\nParsing: " + inputString);
        for (int i = 0; i < formatters.length; i++) {
            try {
                System.out.printf("%-24s: %s%n", locales[i].getDisplayName(), formatters[i].parse(inputString));
            } catch (ParseException e) {
                System.out.println(e);
            }
        }
    }
}
