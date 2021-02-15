package bibi;

public class Pawn {
    private final String color;
    public final static String WHITE = "white";
    public final static String BLACK = "black";

    Pawn(String color) {
        this.color = color;
    }

    Pawn() {
        this.color = WHITE;
    }

    public String getColor() {
        return color;
    }
}
