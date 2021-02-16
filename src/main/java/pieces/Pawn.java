package pieces;

public class Pawn {
    private final String color;
    public final static String WHITE = "white";
    public final static String BLACK = "black";

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn() {
        this.color = WHITE;
    }

    public String getColor() {
        return color;
    }
}
