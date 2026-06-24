package tdd;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); // runs before every test
    }

    @After
    public void tearDown() {
        calculator = null; // runs after every test
    }

    @Test
    public void testAdd() {
        // Arrange
        // Act
        int result = calculator.add(2, 3);
        // Assert
        assertEquals(5, result);
    }
    @Test
    public void testSubtract() {
        // Arrange - already done in @Before
        // Act
        int result = calculator.subtract(10, 3);
        // Assert
        assertEquals(7, result);
    }

    @Test
    public void testMultiply() {
        int result = calculator.multiply(4, 3);
        assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        int result = calculator.divide(10, 2);
        assertEquals(5, result);
    }


    @Test
    public void testAssertions() {
        assertTrue(calculator.add(2, 3) > 0);
        assertFalse(calculator.subtract(3, 5) > 0);
        assertNotNull(calculator);
        assertNull(null);
    }

}