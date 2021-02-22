package net.coco.pieces;

import net.coco.valid.PieceValid;

import java.util.Arrays;

public enum PieceType {
    PAWN('p', 1.0),
    KNIGHT('n', 2.5),
    ROOK('r', 5.0),
    BISHOP('b', 3.0),
    QUEEN('q', 9.0),
    KING('k', 0.0),
    NO_PIECE('.', 0.0);

    private char representation;
    private double score;

    PieceType(char representation, double score) {
        this.representation = representation;
        this.score = score;
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

    public double getScore() {
        return score;
    }
}
