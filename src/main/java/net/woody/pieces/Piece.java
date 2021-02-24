package net.woody.pieces;

import net.woody.chess.Type;

import java.util.Objects;

public class Piece {
    public static final int BLACK_PIECES_RANK = 0;
    public static final int BLACK_PAWN_RANK = 1;
    public static final int WHITE_PAWN_RANK = 6;
    public static final int WHITE_PIECES_RANK = 7;

    private Color color;
    private char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = color.getRepresentation(representation);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN.value());
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN.value());
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT.value());
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT.value());
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK.value());
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK.value());
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP.value());
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP.value());
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN.value());
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN.value());
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING.value());
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return representation == piece.representation && color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, representation);
    }
}
