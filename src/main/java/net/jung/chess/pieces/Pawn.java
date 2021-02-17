package net.jung.chess.pieces;

import net.jung.chess.Color;

public class Pawn {
    private Color color;
    private char representation;

    public Pawn() { this(Color.WHITE); }

    public Pawn(Color color) {
        this.color = color;
        representation = color == Color.WHITE ? 'p' : 'P';
    }

    public Color getColor() { return color; }

    public char getRepresentation() { return representation; }
}
