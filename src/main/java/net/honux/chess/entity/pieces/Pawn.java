package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;

public class Pawn extends Piece {

    public Pawn(String name, Color color, Pointer startPointer) {
        super(name, color, startPointer);
    }

    @Override
    public void move(Pointer pointer) {
    }

    @Override
    public void killPiece(Pointer pointer) {

    }

    @Override
    public void printPointer() {

    }
}
