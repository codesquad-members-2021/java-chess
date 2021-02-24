package chess.domain.pieces;

public abstract class Piece {
    private final char representation;
    private final Color color;

    Piece(Color color) {
        this.color = color;
        representation = color.generateRepresentation(getIcon());
    }

    abstract char getIcon();

    @Override
    public String toString() {
        return String.valueOf(representation);
    }
}
