package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;

public class Pawn extends Piece {

//    public Pawn(){ }

    public Pawn(){
        super('p', Color.WHITE);
    }


    public Pawn(char name, Color color) {
        super(name, color);
    }

    @Override
    public void move() {
    }

    @Override
    public void killPiece() {

    }

    @Override
    public void printPointer() {

    }
}
