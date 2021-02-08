package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;

public class Pawn extends Piece{

    public Pawn(Color color, Pointer startPointer) {
        super(color, startPointer);
    }

    @Override
    void move() {

    }

    @Override
    void kill() {

    }
}
