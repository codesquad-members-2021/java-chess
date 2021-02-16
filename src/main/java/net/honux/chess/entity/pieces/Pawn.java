package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;

public class Pawn {

    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';
    private final Color color;
    private final char representation;

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(Color color) {
        this.color = color;
        char defaultRepresentation = WHITE_REPRESENTATION;
        if (color == Color.BLACK) {
            defaultRepresentation = BLACK_REPRESENTATION;
        }
        representation = defaultRepresentation;
    }

    public Pawn(Color color, char representation) {
        this(color);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return this.representation;
    }
}
