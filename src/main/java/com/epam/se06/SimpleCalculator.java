package com.epam.se06;

import java.util.stream.IntStream;

public class SimpleCalculator implements Calculator {

    @Override
    public int add(int augend1, int augend2) {
        return augend1 + augend2;
    }

    @Override
    public int subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    @Override
    public int multiply(int multiplier1, int multiplier2) {
        return multiplier1 * multiplier2;
    }

    @Override
    public double divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be equal to zero!");
        }
        return (double) dividend / divisor;
    }

    @Override
    public double root(int number, int root) {
        if (root == 0) {
            throw new IllegalArgumentException("Root can't be equal to zero!");
        }
        return Math.pow(Math.E, Math.log(number) / root);
    }

    @Override
    public int power(int number, int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power can't be less then zero!");
        }
        return (int) Math.pow(number, power);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Primitive implementation just for test purposes.
     */
    @Override
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        return IntStream.range(2, number)
                        .noneMatch(value -> number % value == 0);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Primitive implementation just for test purposes.
     */
    @Override
    public int getFibonacci(int index) {
        if (index < 2) {
            return index;
        } else {
            return getFibonacci(index - 1) + getFibonacci(index - 2);
        }
    }
}

