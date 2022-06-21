import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTests {
    //    @Test
//    @DisplayName("Add 1 and 2, result should be 3")
//    void testAddition() {
//        Calculator calculator = new Calculator();
//        int result = calculator.add(1, 2);
//
//        assertEquals(3, result);
//    }
//
//    @Test
//    @DisplayName("Add 2 and 2, result should be 4")
//    void testAddition2() {
//        Calculator calculator = new Calculator();
//        int result = calculator.add(2, 2);
//
//        assertEquals(4, result);
//    }
//
//
//    @Test
//    @DisplayName("divide 4 and 2, result should be 2")
//    void name() {
//        Calculator calculator = new Calculator();
//        int result = calculator.divide(4, 2);
//
//        assertEquals(2, result);
//    }
//
//    @Test
//    void testMultiplication() {
//        Calculator calculator = new Calculator();
//        int result =  calculator.multiply(2, 3);
//        assertEquals(6, result);
//    }
//
//
//    @Test
//    void testSum() {
//        Calculator calculator = new Calculator();
//        Collection<Integer> collection = null;
//
//        assertEquals(0, calculator.sum(collection));
//    }
//
//
//    @Test
//    void testMaxFirstArgGreaterThanSecondArg() {
//        Calculator calculator = new Calculator();
//        int result = calculator.maxOf(2, 1);
//        int expected = 2;
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testMaxFirstArgLessThanSecondArg() {
//        Calculator calculator = new Calculator();
//        int result = calculator.maxOf(1, 2);
//        int expected = 2;
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testMaxFirstArgEqualToSecondArg() {
//        Calculator calculator = new Calculator();
//        int result = calculator.maxOf(2, 2);
//        int expected = 2;
//
//        assertEquals(expected, result);
//    }
    //@DisplayName("{index} => maxOf({0}, {1}) == {2}")
    @ParameterizedTest(name = "{index}: fib({0})={1}")
    //@ParameterizedTest(name = "{index} => maxOf({0}, {1}) == {2}")
    @CsvSource({"2, 1, 2", "1, 2, 2", "1, 1, 1"})
    void testMax(int first, int second, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.maxOf(first, second);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 2, 4, 1000 })
    void testIsEven(Integer arg) {
        assertTrue(new Calculator().isEven(arg));
    }

    @ParameterizedTest
    @EmptySource
    void testEmpty(int[] arg) {
        assertEquals(0, arg.length);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testNullAndEmpty(List<String> arg) {
        assertTrue(arg == null || arg.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringFactory")
    void testStrings(String str) {
        assertFalse(str.isEmpty());
    }

    static List<String> stringFactory() {
        return List.of("apple", "banana", "lemon", "orange");
    }

    @ParameterizedTest
    @MethodSource("argFactory")
    void testStringLength(String str, int length) {
        assertEquals(length, str.length());
    }

    static List<Arguments> argFactory() {
        return List.of(arguments("apple", 5), arguments("watermelon", 10));
    }

    @ParameterizedTest
    @CsvSource({ "apple, 5", "strawberry, 10", "cherry, 6" })
    void testStringLength2(String str, int length) {
        assertEquals(length, str.length());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataset.csv", numLinesToSkip = 1)
    void testStringLength3(String str, int length) {
        assertEquals(length, str.length());
    }
}