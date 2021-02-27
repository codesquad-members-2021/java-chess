package chess.domain.pieces;

public abstract class Piece implements Comparable<Piece> {
    private final char representation;
    private final Color color;

    Piece(Color color) {
        this.color = color;
        representation = color.generateRepresentation(getIcon());
    }

    abstract char getIcon();

    public abstract boolean isPawn();

    public abstract double getScore();

    public boolean isSameColor(Color color) {
        return this.color.equals(color);
    }

    @Override
    public String toString() {
        return String.valueOf(representation);
    }

    @Override
    public int compareTo(Piece piece) {
        return Double.compare(getScore(), piece.getScore());
    }
}
