package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    @Test
    void UnitMeasureHasNoInput() {
        double result = calculator.calculate("", "10 cm + 1 m - 10 mm");
        assertEquals(1090.0, result);
    }

    @Test
    void ExpressionHasNoInput() {
        double result = calculator.calculate("mm", "");
        assertEquals(0, result);
    }

    @Test
    void bothInputsAreEmpty() {
        double result = calculator.calculate("", "");
        assertEquals(0, result);
    }

    @Test
    void wrongExpressionInput() {
        double result = calculator.calculate("mm", "c4x3@#$%^!2221");
        assertEquals(0, result);
    }

    @Test
    void wrongUnitMeasureInput() {
        double result = calculator.calculate("invalid input", "1 m + 1 m + 1 m");
        assertEquals(3000, result);
    }

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