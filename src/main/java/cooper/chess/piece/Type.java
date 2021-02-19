package cooper.chess.piece;

public enum Type {
    PAWN('p'),
    KNIGHT('k'),
    ROOK('r'),
    BISHOP('b'),
    QUEEN('q'),
    KING('k');

    private final Character representaion;

    Type(Character representaion) {
        this.representaion = representaion;
    }

    public char getRepresentaion() {
        return representaion;
    }
}
