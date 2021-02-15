package pieces;

public class Pawn {

    private final Color color;
    private final char representation;

    public Pawn() {
        this(Color.WHITE);
    }

    public Pawn(Color color) {
        this.color = color;

        char representation = '.';
        if (color == Color.WHITE) {
            representation = 'p';
        }
        if (color == Color.BLACK) {
            representation = 'P';
        }
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

}
