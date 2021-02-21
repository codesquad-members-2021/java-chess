package net.sky.pieces;

public class Piece {

    private final Color color;
    private final PieceType pieceType;
    private final char representation;

    public Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        this.representation = classifyRepresentation();
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

    public boolean isWhite(Piece piece) {
        return piece.getColor() == Color.WHITE;
    }

    public boolean isBlack(Piece piece) {
        return piece.getColor() == Color.BLACK;
    }

    private char classifyRepresentation() {
        char initRepresentation = pieceType.getRepresentation();
        return color == Color.BLACK ? Character.toUpperCase(initRepresentation) : initRepresentation;
    }

}
