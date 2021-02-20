package cooper.chess.piece;

public enum Type {
    PAWN('p'),
    KNIGHT('n'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k');

    private final Character representation;

    Type(Character representation) {
        this.representation = representation;
    }

    public char getRepresentaion(Color color) {
        return color == Color.WHITE ?
                Character.toUpperCase(representation) : representation ;
    }
}
