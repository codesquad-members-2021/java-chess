package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;

public class Queen extends Piece{

    public Queen(char name, Color color, Pointer currentPointer) {
        super(name, color, currentPointer);
    }

    @Override
    void move(Pointer pointer) {

    }

    @Override
    void killPiece(Pointer pointer) {

    }

    @Override
    void printPointer() {

    }
}
