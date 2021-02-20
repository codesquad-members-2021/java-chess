package net.kjk402.chess.utils;

public class StringUtils {
    private static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String str) {
        return str + NEWLINE;
    }

    private StringUtils() {

    }

}
