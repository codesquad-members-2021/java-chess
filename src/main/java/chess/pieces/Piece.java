package chess.pieces;

public abstract class Piece {
    private final Color color;

    public Piece() {
        color = Color.WHITE;
    }

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    abstract String getIcon();

    public String getRepresentation() {
        return color.generateRepresentation(getIcon());
    }

    @Override
    public String toString() {
        return getRepresentation();
    }
}
