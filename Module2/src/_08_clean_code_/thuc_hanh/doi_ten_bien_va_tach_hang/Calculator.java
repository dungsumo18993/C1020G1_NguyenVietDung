package _08_clean_code_.thuc_hanh.doi_ten_bien_va_tach_hang;

public class Calculator {
    public static int calculate(int fistOperand, int secondOperand, char operator) {
        final char ADDITION = '+';
        final char SUBTRACTION = '-';
        final char MULTIPLICATION = '*';
        final char DIVISION = '/';
        switch (operator) {
            case ADDITION:
                return fistOperand + secondOperand;
            case SUBTRACTION:
                return fistOperand - secondOperand;
            case MULTIPLICATION:
                return fistOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return fistOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
