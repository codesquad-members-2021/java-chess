package net.honux.chess.util;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static void appendNewLine(StringBuilder sb, char s) {
        sb.append(s).append(NEWLINE);
    }

    public static String convertString(StringBuilder sb) {
        return sb.toString();
    }

}
