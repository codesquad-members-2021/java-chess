package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Type;

import java.util.Objects;

public class Piece {

    private final Color color;
    private final char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE.getRepresentation(Color.NOCOLOR));
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

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type.getRepresentation(Color.WHITE));
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type.getRepresentation(Color.BLACK));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.color, this.representation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece)) return false;
        Piece piece = (Piece) o;
        return representation == piece.representation && color == piece.color;
    }
}
