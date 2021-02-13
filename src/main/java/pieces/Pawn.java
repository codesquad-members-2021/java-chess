package pieces;

public class Pawn {
    public static final String WHITE_COLOR = "White";
    public static final String BLACK_COLOR = "Black";

    private String color;

    public Pawn() {
        this.color = Pawn.WHITE_COLOR;
    }

    public Pawn(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
