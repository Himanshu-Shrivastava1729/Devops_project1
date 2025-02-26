import org.example.Main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest {

    @Test
    public void testSquareRoot() {
        // Test valid input
        assertEquals(3.0, Main.squareRoot(9), 0.0001);
        assertEquals(4.0, Main.squareRoot(16), 0.0001);

        // Test that negative input throws an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.squareRoot(-1);
        });
        assertEquals("Square root of negative number is not real", exception.getMessage());
    }

    @Test
    public void testFactorial() {
        // Factorial of 0 and 1
        assertEquals(1, Main.factorial(0));
        assertEquals(1, Main.factorial(1));

        // Factorial of a positive number
        assertEquals(120, Main.factorial(5));

        // Test that negative input throws an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.factorial(-1);
        });
        assertEquals("Factorial of negative number is undefined", exception.getMessage());
    }

    @Test
    public void testNaturalLogarithm() {
        // Natural logarithm tests
        assertEquals(0.0, Main.naturalLogarithm(1), 0.0001);
        double e = Math.E;
        assertEquals(1.0, Main.naturalLogarithm(e), 0.0001);

        // Test that non-positive input throws an exception
        Exception exceptionZero = assertThrows(IllegalArgumentException.class, () -> {
            Main.naturalLogarithm(0);
        });
        assertEquals("Logarithm undefined for non-positive numbers", exceptionZero.getMessage());

        Exception exceptionNegative = assertThrows(IllegalArgumentException.class, () -> {
            Main.naturalLogarithm(-5);
        });
        assertEquals("Logarithm undefined for non-positive numbers", exceptionNegative.getMessage());
    }

    @Test
    public void testPowerFunction() {
        // Test positive exponent
        assertEquals(8.0, Main.powerFunction(2, 3), 0.0001);
        // Test exponent zero
        assertEquals(1.0, Main.powerFunction(5, 0), 0.0001);
        // Test negative exponent
        assertEquals(0.25, Main.powerFunction(2, -2), 0.0001);
        // Test another positive exponent
        assertEquals(16.0, Main.powerFunction(4, 2), 0.0001);
    }
}
