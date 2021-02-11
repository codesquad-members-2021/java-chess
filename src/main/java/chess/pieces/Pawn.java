package chess.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION;
    public static final char BLACK__REPRESENTATION;

    private String color;

    public Pawn() {
        this(WHITE_COLOR);
    }

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn(String color, char representation) {
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
    }
}


