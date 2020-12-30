package _18_string_regex_.bai_tap.validate_sdt;

import java.util.Scanner;

public class PhoneNumberTest {
    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter PhoneNumber: ");
        String string = scanner.nextLine();

        boolean isvidal=phoneNumber.Validate(string);
        System.out.println("PhoneNumber is " + string + " is vidal " + isvidal);
    }
}
