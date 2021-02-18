package net.honux.chess.util;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");
    private static StringBuilder sb = new StringBuilder();

    private StringUtils() {
    }

    public static StringBuilder append(String s) {
        return sb.append(s);
    }

    public static void appendNewLine(String s) {
        sb.append(s).append(NEWLINE);
    }

    public static String convertString() {
        return sb.toString();
    }

    public static void init() {
        sb = new StringBuilder();
    }
}
