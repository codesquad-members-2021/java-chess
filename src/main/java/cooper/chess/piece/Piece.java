package cooper.chess.piece;

public class Piece {
    private final Color color;
    private final char representation;

    public Piece(String color) {
        this.color = Color.of(color);
        this.representation = this.color.getRepresentation();
    }

    public Piece() {
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
