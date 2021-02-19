package cooper.chess.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final StringBuilder stringBuilder = new StringBuilder();


    public static void appendNewLine(String str) {
        stringBuilder.append(str).append(StringUtils.NEWLINE);
    }

    public static String convertToString () {
        return stringBuilder.toString();
    }
}
