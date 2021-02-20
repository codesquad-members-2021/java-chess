package mj.chess.pieces;

public class Pawn {
    public final static char WHITE_REPRESENTATION = 'p';
    public final static char BLACK_REPRESENTATION = 'P';

    private final Color color;
    private final char representation;

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(Color color) {
        this.color = color;
        this.representation = (color == Color.BLACK) ? BLACK_REPRESENTATION : WHITE_REPRESENTATION;
    }

    public Pawn(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

}
