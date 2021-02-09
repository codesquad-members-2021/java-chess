package pieces;

public class Pawn {
    static final String WHITE = "white";
    static final String BLACK = "black";

    String color;

    public Pawn() {
        this.color = WHITE;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


}
