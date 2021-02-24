package piece;

import piece.attribute.*;

import java.util.Objects;

public abstract class Piece implements Comparable<Piece> {
    private final Color color;
    private final Type type;

    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return isWhite() ? type.getWhiteRepresentation() : type.getBlackRepresentation();
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public double getPoint() {
        return type.getDefaultPoint();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            return color == ((Piece) obj).color && type == ((Piece) obj).type;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    @Override
    public int compareTo(Piece piece) {
        return (int) (piece.getPoint() - this.getPoint());
    }

    @Override
    public String toString() {
        return getRepresentation() + "";
    }
}



