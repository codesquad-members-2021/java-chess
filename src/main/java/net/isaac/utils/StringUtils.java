package net.isaac.utils;

public class StringUtils {
    private StringUtils() {
    }

    private static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String string) {
        return string + NEWLINE;
    }
}
