package cooper.chess.piece;

public class Pawn {
    private final Color color;
    private final char representation;

    public Pawn(String color) {
        this.color = Color.of(color);
        this.representation = this.color.getRepresentation();
    }

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = color.getRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
