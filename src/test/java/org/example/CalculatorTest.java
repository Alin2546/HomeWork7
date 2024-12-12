package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

/**
 * * Test class for the {@code Calculator} class.
 * <p>
 * It handles empty inputs,  invalid expressions, and correct calculations for different units of measure.
 * </p>
 */
class CalculatorTest {
    static Calculator calculator;

    /**
     * Sets up the test environment by initializing the {@link Calculator} instance.
     */
    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    /**
     * Tests the scenario where the unit measure is empty but a valid expression is provided.
     * Verifies that the default unit of measure is used in the calculation.
     */
    @Test
    void UnitMeasureHasNoInput() {
        double result = calculator.calculate("", "10 cm + 1 m - 10 mm");
        assertEquals(1090.0, result);
    }

    /**
     * Tests the scenario where the expression is empty but a valid unit measure is provided.
     * Verifies that the result is zero.
     */
    @Test
    void ExpressionHasNoInput() {
        double result = calculator.calculate("mm", "");
        assertEquals(0, result);
    }

    /**
     * Tests the scenario where both inputs (unit measure and expression) are empty.
     * Verifies that the result is zero.
     */
    @Test
    void bothInputsAreEmpty() {
        double result = calculator.calculate("", "");
        assertEquals(0, result);
    }

    /**
     * Tests the scenario where the expression contains invalid characters.
     * Verifies that the result is zero.
     */
    @Test
    void wrongExpressionInput() {
        double result = calculator.calculate("mm", "c4x3@#$%^!2221");
        assertEquals(0, result);
    }

    /**
     * Tests the scenario where the unit measure is invalid but the expression is valid.
     * Verifies that the calculation defaults to millimeters.
     */
    @Test
    void wrongUnitMeasureInput() {
        double result = calculator.calculate("invalid input", "1 m + 1 m + 1 m");
        assertEquals(3000, result);
    }

    /**
     * Parameterized test for multiple scenarios with various unit measures and expressions.
     *
     * @param unitMeasure The unit of measure to be used in the calculation.
     * @param expression  The mathematical expression to be evaluated.
     * @param expected    The expected result of the calculation.
     */
    @ParameterizedTest
    @CsvSource({
            "mm , 100cm + 100cm - 20cm, 1800",
            "m , 100m + 25m + 10mm, 125",
            "cm, 10m + 5m - 5m, 1000",
            "dm, 10dm - 8cm, 9.2",
            "dm, 100m - 80cm, 992",
            "km, 100m + 100m, 0.2",
            "m, 10km - 100m - 2km - 1dm, 7899.9"
    })
    void testMultipleScenarios(String unitMeasure, String expression, double expected) {
        double result = calculator.calculate(unitMeasure, expression);
        assertEquals(expected, result, 0.02);
    }
}


