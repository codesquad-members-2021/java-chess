package net.eno.pieces;

public enum PieceType {

    WHITE_PAWN("white", 'p'),
    WHITE_ROOK("white", 'r'),
    WHITE_KNIGHT("white", 'n'),
    WHITE_BISHOP("white", 'b'),
    WHITE_QUEEN("white", 'q'),
    WHITE_KING("white", 'k'),
    BLACK_PAWN("black", 'P'),
    BLACK_ROOK("black", 'R'),
    BLACK_KNIGHT("black", 'N'),
    BLACK_BISHOP("black", 'B'),
    BLACK_QUEEN("black", 'Q'),
    BLACK_KING("black", 'K'),
    NO_PIECE("", '.');

    private final String color;
    private final char representation;

    PieceType(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }

}
