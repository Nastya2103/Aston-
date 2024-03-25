package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGetFactorial {

    @Test
    public void testCalculateFactorial() {
        CalculatorFactorial calculator = new CalculatorFactorial();
        int result = calculator.calculateFactorial(6);
        assertEquals(720, result);
}

    @Test
    public void negativeTestCalculateFactorial() {
        CalculatorFactorial calculator = new CalculatorFactorial();
        int result = calculator.calculateFactorial(5);
        assertEquals(420, result);
    }

}
