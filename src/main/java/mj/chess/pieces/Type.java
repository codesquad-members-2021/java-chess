package mj.chess.pieces;

public enum Type {
    BISHOP("b"),
    KING("k"),
    KNIGHT("n"),
    PAWN("p"),
    QUEEN("q"),
    ROOK("r"),
    BLANK(".");

    private final String representation;

    Type(String representation) {
        this.representation = representation;
    }

    public String getRepresentation(Color color) {
        if (color == Color.BLACK) {
            return representation.toUpperCase();
        }

        return representation;
    }
}
