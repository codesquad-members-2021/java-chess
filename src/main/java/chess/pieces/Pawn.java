package chess.pieces;

public class Pawn {
    private final Color color;

    Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }


    public String getColor()
    { return color.getColorName();
    }

    public char getRepresentation() {
        return color.getRepresentation();
    }

}
