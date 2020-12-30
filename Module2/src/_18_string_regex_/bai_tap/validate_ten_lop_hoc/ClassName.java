package _18_string_regex_.bai_tap.validate_ten_lop_hoc;

public class ClassName {
    private static final String NAME_REGEX = "[ACP]+[\\d]{4}+[GHIKLM]";

    public ClassName() {

    }

    public boolean Validate(String regex){
        return regex.matches(NAME_REGEX);
    }
}
