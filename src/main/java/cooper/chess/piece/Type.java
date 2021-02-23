package cooper.chess.piece;

public enum Type {
    PAWN('p'),
    KNIGHT('n'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k'),
    NO_PIECE('.');;

    private final Character representation;

    Type(Character representation) {
        this.representation = representation;
    }

    public char getRepresentaion(Color color) {
        if (color == Color.WHITE) {
            return Character.toUpperCase(representation);
        }

        if (color == Color.BLACK) {
            return representation;
        }

        return NO_PIECE.representation;
    }

}
