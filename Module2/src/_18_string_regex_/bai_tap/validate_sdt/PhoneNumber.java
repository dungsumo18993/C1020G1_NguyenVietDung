package _18_string_regex_.bai_tap.validate_sdt;

public class PhoneNumber {
    private static final String PHONENUMBER_REGEX = "(\\+84|0)[\\d]{9}";

    public PhoneNumber() {
    }

    public boolean Validate(String string){
        return string.matches(PHONENUMBER_REGEX);
    }
}
