package pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char BLACK_REPRESENTATION = 'P';
    public static final char WHITE_REPRESENTATION = 'p';

    private final String color;
    private final char representation;

    public Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public Piece(String color) {
        this(color, WHITE_REPRESENTATION);
    }

    public Piece() {
        this(WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

}
