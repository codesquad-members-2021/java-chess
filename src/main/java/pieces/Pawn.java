package pieces;

public class Pawn {

    private final Color color;
    private final char Representation;

    public Pawn() {
        this.color = Color.WHITE;
        this.Representation = Color.WHITE.getRepresentation();
    }

    public Pawn(Color color) {
        this.color = color;
        this.Representation = color.getRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return Representation;
    }
}
