package net.honux.chess.util;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");
    private static final StringBuilder sb = new StringBuilder();

    private StringUtils() {
    }

    public static void appendNewLine(String s) {
        sb.append(s).append(NEWLINE);
    }

    public static String convertString() {
        return sb.toString();
    }
}
