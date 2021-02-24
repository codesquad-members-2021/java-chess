package net.jung.chess.pieces;

public enum Type {
    PAWN('p', 'P'),
    KNIGHT('n', 'N'),
    ROOK('r', 'R'),
    BISHOP('b', 'B'),
    QUEEN('q', 'Q'),
    KING('k', 'K');

    private final char whiteRepresentation;
    private final char blackRepresentation;

    Type(char whiteRepresentation, char blackRepresentation) {
        this.whiteRepresentation = whiteRepresentation;
        this.blackRepresentation = blackRepresentation;
    }

    public char getWhiteRepresentation(){
        return whiteRepresentation;
    }

    public char getBlackRepresentation(){
        return blackRepresentation;
    }
}
