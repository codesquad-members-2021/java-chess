package utils;

import chess.Board;

public class StringUtils {
    private static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {

    }

    public static String addNewLine(String text) {
        return text + NEWLINE;
    }

    public static String getNewLine(){
        return NEWLINE;
    }
}
