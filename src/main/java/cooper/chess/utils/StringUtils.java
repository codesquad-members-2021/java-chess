package cooper.chess.utils;

public class StringUtils {
    public static final String NEW_LINE = System.getProperty("line.separator");
    private static final StringBuilder stringBuilder = new StringBuilder();


    public static void appendNewLine(String str) {
        stringBuilder.append(str).append(StringUtils.NEW_LINE);
    }

    public static String convertToString () {
        return stringBuilder.toString();
    }
}
