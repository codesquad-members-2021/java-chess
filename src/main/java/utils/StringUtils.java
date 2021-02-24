package utils;

public class StringUtils {
    public static final String NEW_LINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String appendNewLine(String text) {
        return text + NEW_LINE;
    }
}
