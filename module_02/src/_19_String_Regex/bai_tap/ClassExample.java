package _19_String_Regex.bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private static final String NAME_REGEX = "^[CAP][0-9]{4}[G-M]$";

    public ClassExample() {
    }

    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return  matcher.matches();
    }
}
