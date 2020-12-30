package _18_string_regex_.bai_tap.validate_ten_lop_hoc;

import java.util.Scanner;

public class ClassNameTest {
    public static void main(String[] args) {
        ClassName className = new ClassName();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ClassName: ");
        String string = scanner.nextLine();

        boolean isvalid = className.Validate(string);
        System.out.println("ClassName is " + string + " is valid " + isvalid);
    }
}
