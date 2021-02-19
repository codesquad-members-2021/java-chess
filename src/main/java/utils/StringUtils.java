package utils;

import chess.Board;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {

    }

    public static String addNewLine(String text) {
        if (text.length() > Board.BOARD_SIZE) {
            return text.substring(0, 8) + NEWLINE + text.substring(8) + NEWLINE;
        }
        return text + NEWLINE;
    }
}
