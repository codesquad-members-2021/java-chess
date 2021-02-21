package net.sky.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static String appendNewLine(String line) {
        return line + System.getProperty("line.separator");
    }
}
