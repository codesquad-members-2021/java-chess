package net.tree.pieces;

public enum Pieces {

    WHITE_PAWN("white", 'p'),
    BLACK_PAWN("black", 'P'),
    WHITE_KNIGHT("white", 'n'),
    BLACK_KNIGHT("black", 'N'),
    WHITE_BISHOP("white", 'b'),
    BLACK_BISHOP("black", 'B'),
    WHITE_ROOK("white", 'r'),
    BLACK_ROOK("black", 'R'),
    WHITE_QUEEN("white", 'q'),
    BLACK_QUEEN("black", 'Q'),
    WHITE_KING("white", 'k'),
    BLACK_KING("black", 'K');

    private String color;
    private char representation;

    Pieces(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

}
