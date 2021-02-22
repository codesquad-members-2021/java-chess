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

    public static Piece createBlackKnight() {
        return new Piece(Color.WHITE, Representation.KNGINT.black());
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Representation.KNGINT.white());
    }

    public static Piece createBlackRook() {
        return new Piece(Color.WHITE, Representation.ROOK.black());
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Representation.ROOK.white());
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.WHITE, Representation.BISHOP.black());
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Representation.BISHOP.white());
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.WHITE, Representation.QUEEN.black());
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Representation.QUEEN.white());
    }

    public static Piece createBlackKing() {
        return new Piece(Color.WHITE, Representation.KING.black());
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Representation.KING.white());
    }
}
