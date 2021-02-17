package chess.pieces;

public class Piece {
    private final String representation;
    private final Color color;

    public Piece(String representation) {
        this.representation = representation;
        color = Color.WHITE;
    }

    public Piece(String representation, Color color) {
        this.representation = representation;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        return color.generateRepresentation(representation);
    }

    @Override
    public String toString() {
        return getRepresentation();
    }
}
