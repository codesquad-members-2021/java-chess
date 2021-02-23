package net.eno.pieces;

import java.util.Objects;

public class Piece {

    private final Color color;
    private final PieceType pieceType;
    private Position position;

    private Piece(Color color, PieceType pieceType, Position position) {
        this.color = color;
        this.pieceType = pieceType;
        this.position = position;
    }

    public static Piece createPiece(Color color, PieceType pieceType, Position position) {
        return new Piece(color, pieceType, position);
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

    public boolean isWhite() {
        return getColor().equals(Color.WHITE);
    }

    public boolean isBlack() {
        return getColor().equals(Color.BLACK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return this.color == piece.color &&
                this.pieceType == piece.pieceType &&
                Objects.equals(this.position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, pieceType, position);
    }
}
