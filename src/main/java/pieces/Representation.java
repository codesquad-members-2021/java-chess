package pieces;

public enum Representation {
    PAWN('P'), KNIGHT('N'), ROOK('R'), BISHOP('B'), QUEEN('Q'), KING('K');

    private char representation;

    Representation(char representation) {
        this.representation = representation;
    }

    public char value() {
        return representation;
    }
}
