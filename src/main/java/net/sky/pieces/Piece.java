package net.sky.pieces;

public class Piece {

    private final Color color;
    private final PieceType pieceType;
    private final char REPRESENTATION;

    private Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        this.REPRESENTATION = classifyRepresentation();
    }

    public static Piece createPiece(Color color, PieceType pieceType) {
        return new Piece(color, pieceType);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return REPRESENTATION;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    private char classifyRepresentation() {
        char initRepresentation = pieceType.getRepresentation();
        if (color == Color.BLACK) {
            return Character.toUpperCase(initRepresentation);
        }
        return initRepresentation;
    }

}
