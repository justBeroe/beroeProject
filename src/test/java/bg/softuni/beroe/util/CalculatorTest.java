package bg.softuni.beroe.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculatorToTest;

    @BeforeEach
    void setUp()  {

        calculatorToTest = new Calculator();
    }

    @Test
    void testSum() {

        Assertions.assertEquals(4, calculatorToTest.sum(2, 2));
        Assertions.assertEquals(10, calculatorToTest.sum(8, 2));
        Assertions.assertEquals(15, calculatorToTest.sum(10, 5));
    }

    @Test
    void testMultiply() {

        Assertions.assertEquals(4, calculatorToTest.multiply(2, 2));
        Assertions.assertEquals(12, calculatorToTest.multiply(4, 3));
        Assertions.assertEquals(16, calculatorToTest.multiply(4, 4));
    }
}
