package net.woody.utils;

public class StringUtils {

    private static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String appendNewLine(String line) {
        return new StringBuilder(line)
                .append(NEWLINE)
                .toString();
    }
}

