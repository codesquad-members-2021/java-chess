package net.coco.pieces;

import net.coco.valid.PieceValid;

import java.util.Arrays;

public enum PieceType {
    PAWN('p'),
    KNIGHT('n'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k'),
    NO_PIECE('.');

    private char representation;

    PieceType(char representation) {
        this.representation = representation;
    }

    private char getWhiteRepresentation() {
        return representation;
    }

    private char getBlackRepresentation() {
        return Character.toUpperCase(representation);
    }

    public char getRepresentation(String color) {
        PieceValid.checkColorType(color);
        if (color.equals(Piece.WHITE))
            return getWhiteRepresentation();
        return getBlackRepresentation();
    }
}
