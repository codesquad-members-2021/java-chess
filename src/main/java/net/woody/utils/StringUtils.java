package net.woody.utils;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String appendNewLine(String line) {
        return new StringBuilder()
                .append(line)
                .append(NEWLINE)
                .toString();
    }
}

