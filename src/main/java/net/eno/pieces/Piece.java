package net.eno.pieces;

public class Piece {

    private final PieceType pieceType;

    private Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public static Piece createPiece(PieceType pieceType) {
        return new Piece(pieceType);
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

}
