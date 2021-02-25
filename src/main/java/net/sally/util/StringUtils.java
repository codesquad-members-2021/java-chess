package net.sally.util;

public class StringUtils {
    public static final String NEW_LINE = System.getProperty("line.separator");

    private StringUtils() { }

    public static String appendNewLine(String str) {
        return (str + NEW_LINE);
    }
}
