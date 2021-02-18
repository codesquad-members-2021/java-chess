package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;

public class Piece {

    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';
    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';

    private final Color color;
    private final char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Piece.BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Piece.WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Piece.BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Piece.BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Piece.WHITE_KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Piece.BLACK_KING_REPRESENTATION);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return this.representation;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }
}
