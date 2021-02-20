package mj.chess.utils;

public class StringUtils {
    private StringUtils() {

    }

    public static final String NEWLINE = System.getProperty("line.separator");

    public static StringBuilder appendNewLine(String inputString) {
        StringBuilder newLinePlus = new StringBuilder();
        newLinePlus.append(inputString);
        newLinePlus.append(NEWLINE);
        return newLinePlus;
    }
}
