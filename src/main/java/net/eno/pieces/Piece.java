package net.eno.pieces;

import java.util.Objects;

public class Piece {

    private final PieceType pieceType;
    private Position position;

    private Piece(PieceType pieceType, Position position) {
        this.pieceType = pieceType;
        this.position = position;
    }

    public static Piece createPiece(PieceType pieceType, Position position) {
        return new Piece(pieceType, position);
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public String getColor() {
        return this.pieceType.getColor();
    }

    public char getRepresentation() {
        return this.pieceType.getRepresentation();
    }

    public boolean isWhite() {
        return getColor().equals("white");
    }

    public boolean isBlack() {
        return getColor().equals("black");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return pieceType == piece.pieceType && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType, position);
    }

}
