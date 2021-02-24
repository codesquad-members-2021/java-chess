package utils;

public class StringUtils {

    private StringUtils() {
    }

    public static String appendNewLine(String text) {
        return System.getProperty("line.separator")+ text;
    }
}
