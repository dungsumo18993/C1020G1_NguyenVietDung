package _08_clean_code_.thuc_hanh.doi_ten_bien_va_tach_hang;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

 class CalculatorTest {
    @Test
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        int fistOperand = 1;
        int secondOperand = 1;
        char operator = '+';
        int expected = 2;

        int result = Calculator.calculate(fistOperand, secondOperand, operator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        int fistOperand = 2;
        int secondOperand = 1;
        char operator = '-';
        int expected = 1;

        int result = Calculator.calculate(fistOperand, secondOperand, operator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        int fistOperand = 2;
        int secondOperand = 2;
        char operator = '*';
        int expected = 4;

        int result = Calculator.calculate(fistOperand, secondOperand, operator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    void testCalculateDiv() {
        int fistOperand = 6;
        int secondOperand = 3;
        char operator = '/';
        int expected = 2;

        int result = Calculator.calculate(fistOperand, secondOperand, operator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        int fistOperand = 2;
        int secondOperand = 0;
        char operator = '/';

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(fistOperand, secondOperand, operator);});
    }

    @Test
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        int fistOperand = 2;
        int secondOperand = 0;
        char operator = '=';

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(fistOperand, secondOperand, operator);});
    }
}
