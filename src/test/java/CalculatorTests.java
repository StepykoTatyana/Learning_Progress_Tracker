import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CalculatorTests {
    @Test
    @DisplayName("Add 1 and 2, result should be 3")
    void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("Add 2 and 2, result should be 4")
    void testAddition2() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 2);

        assertEquals(4, result);
    }


    @Test
    @DisplayName("divide 4 and 2, result should be 2")
    void name() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(4, 2);

        assertEquals(2, result);
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        int result =  calculator.multiply(2, 3);
        assertEquals(6, result);
    }


    @Test
    void testSum() {
        Calculator calculator = new Calculator();
        Collection<Integer> collection = null;

        assertEquals(0, calculator.sum(collection));
    }
}