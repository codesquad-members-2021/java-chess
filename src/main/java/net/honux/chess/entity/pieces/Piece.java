package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;

public abstract class Piece {
    private final Color color;
    private Pointer currentPointer;
    private boolean alive = true;
    abstract void move();
    abstract void kill();

    public Piece(Color color, Pointer currentPointer) {
        this.color = color;
        this.currentPointer = currentPointer;
    }


    public Color getColor() {
        return color;
    }

    public void setCurrentPointer(Pointer currentPointer) {
        this.currentPointer = currentPointer;
    }

    public Pointer getCurrentPointer() {
        return currentPointer;
    }
}
