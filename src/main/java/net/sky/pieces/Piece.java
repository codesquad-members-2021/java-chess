package net.sky.pieces;

public class Piece {

    private final Color color;
    private final PieceType pieceType;
    private final char representation;

    private Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        this.representation = pieceType.getRepresentation(color);
    }

    public static Piece createPiece(Color color, PieceType pieceType) {
        return new Piece(color, pieceType);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

}
