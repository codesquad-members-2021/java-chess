package net.eno.pieces;

public enum Representation {

    PAWN('p', 'P'),
    KNIGHT('n', 'N'),
    ROOK('r', 'R'),
    BISHOP('b', 'B'),
    QUEEN('q', 'Q'),
    KING('k', 'K');

    private final char white;
    private final char black;

    Representation(char white, char black) {
        this.white = white;
        this.black = black;
    }

    public char get(Color color) {
        return color.toString().equals("WHITE") ? this.white : this.black;
    }

}
