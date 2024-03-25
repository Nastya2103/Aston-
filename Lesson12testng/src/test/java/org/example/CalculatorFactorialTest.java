package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculatorFactorialTest {
    private CalculatorFactorial factorial = new CalculatorFactorial();

    @Test
    public void calcFactTest() {
        Assert.assertEquals(120, factorial.calculateFactorial(5));
    }

    @Test
    public void calcFactTestNegative() {
        Assert.assertEquals(0, factorial.calculateFactorial(6));
    }
}
