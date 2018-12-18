package com.epam.se06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void createCalculator() {
        calculator = new SimpleCalculator();
    }

    @Nested
    class PositiveTests {

        @Nested
        class SumMethod {
            @Test
            void sumOverflowShouldWorkCorrectly() {
                int result = calculator.add(Integer.MAX_VALUE, 1);

                assertThat(result, is(Integer.MIN_VALUE));
            }

            @Test
            void sumUnderflowShouldWorkCorrectly() {
                int result = calculator.add(Integer.MIN_VALUE, -1);

                assertThat(result, is(Integer.MAX_VALUE));
            }

            @Test
            void sumWithZeroLeftShouldResultSameValue() {
                int original = 42;

                int result = calculator.add(0, original);

                assertThat(result, is(original));
            }

            @Test
            void sumWithZeroRightShouldResultSameValue() {
                int original = 42;

                int result = calculator.add(original, 0);

                assertThat(result, is(original));
            }

            @Test
            void sumTwoPositiveValues() {
                int result = calculator.add(1, 2);

                assertThat(result, is(3));
            }
        }

        @Nested
        class SubtractMethod {

            @Test
            void subtractZeroShouldResultSameValue() {
                int original = 42;

                int result = calculator.subtract(original, 0);

                assertThat(result, is(original));
            }

            @Test
            void subtractFromZeroShouldResultSameNegativeValue() {
                int original = 42;

                int result = calculator.subtract(0, original);

                assertThat(result, is(-original));
            }

            @Test
            void subtractPositiveValues() {
                int result = calculator.subtract(42, 10);

                assertThat(result, is(32));
            }

            @Test
            void subtractNegativeValues() {
                int result = calculator.subtract(-42, -10);

                assertThat(result, is(-32));
            }

            @Test
            void subtractPositiveAndNegativeValues() {
                int result = calculator.subtract(42, -10);

                assertThat(result, is(52));
            }

            @Test
            void subtractNegativeAndPositiveValues() {
                int result = calculator.subtract(-42, 10);

                assertThat(result, is(-52));
            }

            @Test
            void subtractOverflowShouldWorkCorrectly() {
                int result = calculator.subtract(Integer.MAX_VALUE, -1);

                assertThat(result, is(Integer.MIN_VALUE));
            }

            @Test
            void subtractUnderflowShouldWorkCorrectly() {
                int result = calculator.subtract(Integer.MIN_VALUE, 1);

                assertThat(result, is(Integer.MAX_VALUE));
            }
        }

        @Nested
        class MultiplyMethod {

            @Test
            void multiplyWithZeroShouldReturnZero() {
                int result = calculator.multiply(42, 0);

                assertThat(result, is(0));
            }

            @Test
            void multiplyWithOneShouldReturnSameValue() {
                int originalValue = 42;

                int result = calculator.multiply(originalValue, 1);

                assertThat(result, is(originalValue));
            }

            @Test
            void multiplyTwoPositiveValueShouldProducePositiveValue() {
                int result = calculator.multiply(42, 2);

                assertThat(result, is(84));
            }

            @Test
            void multiplyPositiveAndNegativeValueShouldProduceNegativeValue() {
                int result = calculator.multiply(42, -2);

                assertThat(result, is(-84));
            }

            @Test
            void multiplyTwoNegativeValuesShouldProducePositiveValue() {
                int result = calculator.multiply(-42, -2);

                assertThat(result, is(84));
            }

            @Test
            void multiplyOverflowShouldWorkCorrectly() {
                int result = calculator.multiply(Integer.MAX_VALUE / 2 + 1, 2);

                assertThat(result, is(Integer.MIN_VALUE));
            }
        }

        @Nested
        class DivideMethod {

            @Test
            void divideTwoPositiveValuesShouldProducePositiveValue() {
                double result = calculator.divide(10, 5);

                assertThat(result, is(2.0));
            }

            @Test
            void dividePositiveValueByNegativeShouldProduceNegativeValue() {
                double result = calculator.divide(10, -5);

                assertThat(result, is(-2.0));
            }

            @Test
            void divideNegativeValueByPositiveShouldProduceNegativeValue() {
                double result = calculator.divide(-10, 5);

                assertThat(result, is(-2.0));
            }

            @Test
            void divideTwoNegativeValuesShouldProducePositiveValue() {
                double result = calculator.divide(-10, -5);

                assertThat(result, is(2.0));
            }

            @Test
            void divideValuesWithPeriodInResult() {
                double result = calculator.divide(10, 3);

                assertThat(result, closeTo(3.333, 0.001));
            }
        }

        @Nested
        class RootMethod {

            @Test
            void rootFromZeroValueShoulBeZero() {
                double result = calculator.root(0, 2);

                assertThat(result, closeTo(0, 0.001));
            }

            @Test
            void rootFromPositiveValue() {
                double result = calculator.root(100, 2);

                assertThat(result, closeTo(10, 0.001));
            }
        }

        @Nested
        class PowerMethod {

            @Test
            void powerToZeroShouldProduceZero() {
                int result = calculator.power(42, 0);

                assertThat(result, is(1));
            }

            @Test
            void powerToOneShouldProduceSameValue() {
                int original = 10;

                int result = calculator.power(original, 1);

                assertThat(result, is(original));
            }

            @Test
            void powerToSquare() {
                int result = calculator.power(10, 2);

                assertThat(result, is(100));
            }
        }

        @ParameterizedTest(name = "Check value {0} for prime - should be {1}")
        @CsvFileSource(resources = "prime_values.csv", numLinesToSkip = 1)
        void checkFirst10PrimeValues(int value, boolean isPrime) {
            assertThat(calculator.isPrime(value), is(isPrime));
        }

        @ParameterizedTest(name = "Check that {0}-th Fibonacci value is {1}")
        @CsvSource({"0,0", "1,1", "2,1", "3,2", "4,3", "5,5", "6,8", "7,13", "8,21", "9,34"})
        void checkFirst10FibonacciValues(int index, int fibonacciValue) {
            assertThat(calculator.getFibonacci(index), is(fibonacciValue));
        }
    }

    @Nested
    class NegativeTests {

        @Test
        void divideByZeroShouldThrowException() {
            assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
        }

        @Test
        void extractingZeroRootShouldThrowException() {
            assertThrows(IllegalArgumentException.class, () -> calculator.root(10, 0));
        }

        @Test
        void negativePowerShouldThrowException() {
            assertThrows(IllegalArgumentException.class, () -> calculator.power(10, -1));
        }

        @Nested
        class IsPrimeMethod {

            @Test
            void negativeValueNotPrime() {
                assertThat(calculator.isPrime(-1), is(false));
            }

            @Test
            void zeroIsNotPrimeValue() {
                assertThat(calculator.isPrime(0), is(false));
            }

            @Test
            void oneIsNotPrimeValue() {
                assertThat(calculator.isPrime(1), is(false));
            }

            @Test
            void checkTimeoutCalculatingPrimeValue() {
                boolean isPrime = calculator.isPrime(999_983);

                Executable task = () -> assertThat(isPrime, is(true));

                assertTimeoutPreemptively(Duration.ofMillis(10), task);
            }
        }

    }
}