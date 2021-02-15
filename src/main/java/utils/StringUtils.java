package utils;

public class StringUtils {

    public static final String NEWLINE = System.lineSeparator();

    private StringUtils() {
    }

    public static String appendNewLine(String string){
        return string + NEWLINE;
    }
}
