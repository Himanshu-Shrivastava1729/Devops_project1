package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest {

    @Test
    void testSquareRoot() {
        assertEquals(3.0, ScientificCalculator.squareRoot(9), 0.0001);
        assertEquals(5.0, ScientificCalculator.squareRoot(25), 0.0001);
        assertThrows(IllegalArgumentException.class,
                () -> ScientificCalculator.squareRoot(-4));
    }

    @Test
    void testFactorial() {
        assertEquals(1, ScientificCalculator.factorial(0));
        assertEquals(1, ScientificCalculator.factorial(1));
        assertEquals(120, ScientificCalculator.factorial(5));
        assertEquals(3628800, ScientificCalculator.factorial(10));
    }

    @Test
    void testNaturalLogarithm() {
        assertEquals(0.0, ScientificCalculator.naturalLogarithm(1), 0.0001);
        assertEquals(1.0, ScientificCalculator.naturalLogarithm(Math.E), 0.0001);
        assertThrows(IllegalArgumentException.class,
                () -> ScientificCalculator.naturalLogarithm(-1));
    }

    @Test
    void testPowerFunction() {
        assertEquals(8.0, ScientificCalculator.powerFunction(2, 3), 0.0001);
        assertEquals(1.0, ScientificCalculator.powerFunction(5, 0), 0.0001);
        assertEquals(0.25, ScientificCalculator.powerFunction(2, -2), 0.0001);
    }
}