package com.epam.se06;

public interface Calculator {

    int add(int augend1, int augend2);

    int subtract(int minuend, int subtrahend);

    int multiply(int multiplier1, int multiplier2);

    /**
     * @param dividend value to be divided.
     * @param divisor value to divide by.
     * @return result of dividend / divisor.
     * @throws IllegalArgumentException if divisor is equal to zero.
     */
    double divide(int dividend, int divisor);

    /**
     * @param number value from which will be extracted the root.
     * @param root degree of root.
     * @return result of the root extraction.
     * @throws IllegalArgumentException if root is equal to zero.
     */
    double root(int number, int root);

    /**
     * @param number value from which will be extracted the root.
     * @param power of value.
     * @return the result of exponentiation.
     * @throws IllegalArgumentException if power is less than zero.
     */
    int power(int number, int power);

    /**
     * Check number is prime or not.
     * @param number checking value.
     * @return true - prime number, otherwise false.
     */
    boolean isPrime(int number);

    /**
     * Get N-th Fibonacci value.
     * @param index Index of value.
     * @return Fibonacci value of required index.
     */
    int getFibonacci(int index);
}

