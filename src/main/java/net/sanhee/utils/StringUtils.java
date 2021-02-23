package net.sanhee.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String text) {
        return text + NEWLINE;
    }
}
