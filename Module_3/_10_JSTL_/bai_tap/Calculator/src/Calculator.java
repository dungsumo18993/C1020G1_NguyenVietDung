import com.sun.deploy.security.SelectableSecurityManager;

public class Calculator {
    public static double operator (double num1, double num2, String operator){
        switch (operator){
            case "addition":
                return num1 + num2;
            case "subtraction":
                return num1 - num2;
            case "multiplication":
                return num1 * num2;
            case "division":
                if (num2 != 0){
                    return num1 / num2;
                }
                else {
                    throw new RuntimeException("Không thể chia cho 0");
                }
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }
}
