package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;

public abstract class Piece {
    private final char name;
    private final Color color;

    public Piece(char name, Color color) {
        this.name = name;
        this.color = color;
    }

    abstract void move();

    abstract void killPiece();

    abstract void printPointer();

    public char getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

}
