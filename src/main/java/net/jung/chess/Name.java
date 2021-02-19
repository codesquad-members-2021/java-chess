package net.jung.chess;

public enum Name{
    PAWN('p', 'P'),
    KNIGHT('n', 'N'),
    ROOK('r', 'R'),
    BISHOP('b', 'B'),
    QUEEN('q', 'Q'),
    KING('k', 'K');

    private final char whiteRep;
    private final char blackRep;

    Name(char whiteRep, char blackRep) {
        this.whiteRep = whiteRep;
        this.blackRep = blackRep;
    }

    public char getWhiteRep(){
        return whiteRep;
    }

    public char getBlackRep(){
        return blackRep;
    }
}
