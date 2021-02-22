package net.woody.pieces;

import net.woody.chess.Representation;

public class Piece {
    public static final int BLACK_PAWN_RANK = 1;
    public static final int WHITE_PAWN_RANK = 6;

    private Color color;
    private char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Representation.PAWN.black());
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Representation.PAWN.white());
    }

}
