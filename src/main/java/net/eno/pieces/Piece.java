package net.eno.pieces;

public class Piece {

    private final Color color;
    private final PieceType pieceType;

    private Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
    }

    public static Piece createPiece(Color color, PieceType pieceType) {
        return new Piece(color, pieceType);
    }

    public String getColor() {
        return this.color.toString();
    }

    public char getRepresentation() {
        return this.pieceType.getRepresentation(this.color);
    }

    public boolean isWhite() {
        return this.color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return this.color.equals(Color.BLACK);
    }

}
