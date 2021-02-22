package chess.domain.pieces;

public abstract class Piece {
    private final String representation;
    private final Color color;

    Piece(Color color) {
        this.color = color;
        representation = color.generateRepresentation(getIcon());
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
