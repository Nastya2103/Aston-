package org.example;

public class CalculatorFactorial {

    public static int calculateFactorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}

