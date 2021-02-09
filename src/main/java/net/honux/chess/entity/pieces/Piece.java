package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;

public abstract class Piece {
    private final char name;
    private final Color color;
    private Pointer currentPointer;
    private boolean alive = true;

    public Piece(char name, Color color, Pointer currentPointer) {
        this.name = name;
        this.color = color;
        this.currentPointer = currentPointer;
    }

    abstract void move(Pointer pointer);

    abstract void killPiece(Pointer pointer);

    abstract void printPointer();

    public char getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Pointer getCurrentPointer() {
        return currentPointer;
    }

    public void setCurrentPointer(Pointer currentPointer) {
        this.currentPointer.setPointer(currentPointer);
    }
}
