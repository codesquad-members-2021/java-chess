package utils;

public class StringUtils {

    private static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String appendNewLine(String string) {
        return string + NEWLINE;
    }
}
