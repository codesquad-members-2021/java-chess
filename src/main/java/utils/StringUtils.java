package utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {

    }

    public static String addNewLine(String text) {
        return text + NEWLINE;
    }
}
