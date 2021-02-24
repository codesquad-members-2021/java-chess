package net.sanhee.pieces;

public enum UnitType {
    PAWN('P'),
    ROOK('R'),
    KNIGHT('N'),
    BISHOP('B'),
    QUEEN('Q'),
    KING('K'),
    NONE('.');

    private final char unitRepresentation;

    UnitType(char mark) {
        this.unitRepresentation = mark;
    }
}
