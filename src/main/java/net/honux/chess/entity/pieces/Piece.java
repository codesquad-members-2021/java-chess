package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;

public abstract class Piece {
    private String name;
    private Color color;
    private Pointer currentPointer;
    private boolean alive = true;
    abstract void move();
    abstract void kill();

    public Piece(String name, Color color, Pointer currentPointer) {
        this.name = name;
        this.color = color;
        this.currentPointer = currentPointer;
    }
}
