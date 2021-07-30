package Middle;

import java.util.regex.*;

public class example {
	public static void main(String[] args) {

		System.out.println(isRegexPhone("01089751598"));
	}
	
	public static boolean isRegexPhone(String target) {
        String regex = "[0-9]{10,11}";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }

}
