package chess.domain.pieces;

public abstract class Piece {
    private final String representation;
    private final Color color;

    Piece(Color color) {
        this.color = color;
        representation = color.generateRepresentation(getIcon());
    }

    public Color getColor() {
        return color;
    }

    abstract String getIcon();

    public String getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return getRepresentation();
    }
}
