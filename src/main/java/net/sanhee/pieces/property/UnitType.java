package net.sanhee.pieces.property;

public enum UnitType {
    PAWN('P'),
    ROOK('R'),
    KNIGHT('N'),
    BISHOP('B'),
    QUEEN('Q'),
    KING('K'),
    NO_PIECE('.');

    private final char unitRepresentation;

    UnitType(char mark) {
        this.unitRepresentation = mark;
    }

    public static char getMark(UnitColor color, UnitType type) {
        final char mark;

        switch (color) {
            case BLACK:
                mark = Character.toUpperCase(type.unitRepresentation);
                break;
            case WHITE:
                mark = Character.toLowerCase(type.unitRepresentation);
                break;
            case NOCOLOR:
                mark = type.unitRepresentation;
                break;
            default:
                mark = ' ';
        }
        return mark;
    }
}
