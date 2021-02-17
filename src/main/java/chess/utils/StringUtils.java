package chess.utils;

public class StringUtils {
    private static String string = "";

    private StringUtils() { }

    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String line){
        string = string + line + NEWLINE;
        return string;
    }
}
