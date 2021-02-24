package net.kjk402.chess.pieces;

import java.util.Objects;

public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }
    }

    private final Color color;

    private final Type type;

    public Piece(Color color, Type type) {
        this.color = color;
        this.type = type;

    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return isWhite() ? this.type.getWhiteRepresentation() : this.type.getBlackRepresentation();
    }

    public Type getType() {
        return type;
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
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
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    public boolean isWhite() {
        return getColor() == Color.WHITE;
    }

    public boolean isBlack() {
        return getColor() == Color.BLACK;
    }

    public boolean isPawn() {
        return getRepresentation() == Type.PAWN.getBlackRepresentation() || getRepresentation() == Type.PAWN.getWhiteRepresentation();
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object ==null || getClass() != object.getClass()) return false;
        Piece piece = (Piece) object;
        return type == piece.type && color ==piece.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

}
