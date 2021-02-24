package utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    static String appendNewLine(String str) {
        return str + NEWLINE;
    }
}
