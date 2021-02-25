package net.honux.chess.util;

import net.honux.chess.core.Board;

public class Position {

    private Position() {
    }

    public static int getRank(String position) {
        return Character.toLowerCase(position.charAt(0)) - 'a';
    }

    public static int getIndex(String position) {
        return Board.BOARD_SIZE - Character.getNumericValue(position.charAt(1));
    }

}
