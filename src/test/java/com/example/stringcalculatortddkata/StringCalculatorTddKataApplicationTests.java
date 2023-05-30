package com.example.stringcalculatortddkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;


@SpringBootTest
class StringCalculatorTddKataApplicationTests {

    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyString() {
        int result = calculator.add("");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testSingleNumber() {
        int result = calculator.add("1");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testTwoNumbers() {
        int result = calculator.add("1,2");
        Assertions.assertEquals(3, result);
    }

    @Test
    public void testNewLineDelimiter() {
        int result = calculator.add("1\n2,3");
        Assertions.assertEquals(6, result);
    }

    @Test
    public void testCustomDelimiter() {
        int result = calculator.add("//;\n1;2");
        Assertions.assertEquals(3, result);
    }

    @Test
    public void testNegativeNumbers() {
        try {
            calculator.add("-1,2,-3");
            Assertions.fail("Exception should have been thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Negatives not allowed: [-1, -3]", e.getMessage());
        }
    }

    @Test
    public void testNumbersGreaterThan1000() {
        int result = calculator.add("2,1001");
        Assertions.assertEquals(2, result);
    }

}


