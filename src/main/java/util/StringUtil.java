package util;

public class StringUtil {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtil() {
    }

    public static String appendNewLine(String text) {
        if (text.length() > 8) {
            return text.substring(0, 8) + NEWLINE + text.substring(8) + NEWLINE;
        }
        return text + NEWLINE;
    }
}

