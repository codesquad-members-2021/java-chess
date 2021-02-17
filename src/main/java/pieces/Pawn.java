package pieces;

public class Pawn {

    private final Color color;
    private final char colorRepresentation;

    public Pawn() {
        this.color = Color.WHITE;
        this.colorRepresentation = Color.WHITE.getRepresentation();
    }

    public Pawn(Color color) {
        this.color = color;
        this.colorRepresentation = color.getRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public char getColorRepresentation() {
        return colorRepresentation;
    }
}
