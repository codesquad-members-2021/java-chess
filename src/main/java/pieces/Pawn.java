package pieces;

public class Pawn extends Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    private final String color;

    public Pawn() {
        this.color = "white";
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
