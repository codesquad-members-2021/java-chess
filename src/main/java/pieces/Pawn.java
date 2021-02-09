package pieces;

public class Pawn extends Piece {

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
