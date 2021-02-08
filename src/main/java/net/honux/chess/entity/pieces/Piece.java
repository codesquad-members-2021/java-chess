package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;

public abstract class Piece {
    String name;
    Color color;
    Pointer currentPointer;
    boolean alive;
    abstract void move();
    abstract void kill();
}
