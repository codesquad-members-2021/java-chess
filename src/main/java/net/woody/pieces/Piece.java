package net.woody.pieces;

import java.util.Objects;

public class Piece {

    private static final Piece BLANK_PIECE = new Piece(Piece.Color.NOCOLOR, Type.NO_PIECE);


    private Color color;
    private Type type;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return (isBlack()) ? type.getBlackRepresentation() : type.getWhiteRepresentation();
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isPawn() {
        return type == Type.PAWN;
    }

    public static Piece createBlack(Type type) {
        return new Piece(Piece.Color.BLACK, type);
    }

    public static Piece createWhite(Type type) {
        return new Piece(Piece.Color.WHITE, type);
    }

    public static Piece getBlankPiece() {
        return BLANK_PIECE;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return type == piece.type && color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }
}
