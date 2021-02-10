package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;

public class Pawn extends Piece{

    public Pawn(Color color, Pointer startPointer) {
        super(color, startPointer);
    }

    @Override
    public void move(Pointer pointer) {
    }

    @Override
    public void kill(Pointer pointer) {

    }

    @Override
    public void printPointer() {

    }
}
