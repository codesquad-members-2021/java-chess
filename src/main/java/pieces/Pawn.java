package pieces;

public class Pawn {
    private final String color;
    private final String representation;
    public final static String WHITE = "white";
    public final static String BLACK = "black";
    public final static String WHITE_REPRESENTATION = "p";
    public final static String BLACK_REPRESENTATION = "P";

    public Pawn(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public Pawn() {
        this(WHITE, WHITE_REPRESENTATION);
    }

    public String getColor() {
        return color;
    }
}
