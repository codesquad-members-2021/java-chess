package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;
import net.honux.chess.core.Board;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.findPawn(1);
    }
}
