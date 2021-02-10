package chess;

public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    private String color;

    Pawn() {
        this.color = WHITE;
    }

    Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
