package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.PawnName;

public class Pawn {

    private final Color color;
    private final PawnName representation;

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = PawnName.WHITE_REPRESENTATION;
    }

    public Pawn(Color color) {
        this.color = color;
        if (color == Color.BLACK) {
            this.representation = PawnName.BLACK_REPRESENTATION;
        } else
            this.representation = PawnName.WHITE_REPRESENTATION;
    }

    public Pawn(Color color, PawnName representation) {
        this(color);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation.getRepresentation();
    }
}
