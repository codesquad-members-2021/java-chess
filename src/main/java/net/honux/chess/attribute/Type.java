package net.honux.chess.attribute;

public enum Type {
    PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('x');

    private final char representation;

    Type(char representation) {
        this.representation = representation;
    }

    public char getRepresentation(Color color) {
        if(color == Color.BLACK) {return Character.toUpperCase(representation);}
        return representation;
    }
}
