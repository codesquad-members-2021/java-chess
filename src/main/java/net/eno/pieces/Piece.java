package net.eno.pieces;

import java.util.Objects;

public class Piece implements Comparable<Piece> {

    private final Color color;
    private final PieceType pieceType;

    private Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
    }

    public static Piece createPiece(Color color, PieceType pieceType) {
        return new Piece(color, pieceType);
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public Color getColor() {
        return this.color;
    }

    public char getRepresentation(Color color) {
        return this.pieceType.getRepresentation(color);
    }

    public double getPoint() {
        return this.pieceType.getDefaultPoint();
    }

    public boolean isWhite() {
        return getColor() == Color.WHITE;
    }

    public boolean isBlack() {
        return getColor() == Color.BLACK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece)) return false;
        Piece piece = (Piece) o;
        return color == piece.color && pieceType == piece.pieceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, pieceType);
    }

    @Override
    public int compareTo(Piece piece) {
        return (int)(Math.floor(getPoint() - piece.getPoint()));
    }

}
