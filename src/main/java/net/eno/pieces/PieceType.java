package net.eno.pieces;

public enum PieceType {

    PAWN('p', 'P'),
    KNIGHT('n', 'N'),
    ROOK('r', 'R'),
    BISHOP('b', 'B'),
    QUEEN('q', 'Q'),
    KING('k', 'K');

    private final char white;
    private final char black;

    PieceType(char white, char black) {
        this.white = white;
        this.black = black;
    }

    public char getRepresentation(Color color) {
        return color.toString().equals("WHITE") ? this.white : this.black;
    }

}
