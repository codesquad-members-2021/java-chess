package piece;

import java.util.List;
import java.util.Objects;

public class Piece implements Comparable<Piece> {
    private final Color color;
    private final Type type;
    private final Position position;

    public Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    public char getRepresentation() {
        return isRightColor(Color.WHITE) ? this.type.getWhiteRepresentation()
                : this.type.getBlackRepresentation();
    }

    public boolean verifyPiece(Color color, Type type) {
        return matchColor(color) && matchType(type);
    }

    public boolean matchColor(Color color) {
        return this.color == color;
    }

    public boolean matchType(Type type) {
        return this.type == type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public double getPoint() {
        return getType().getDefaultPoint();
    }

    public boolean isRightColor(Color expectedColor) {
        return color.equals(expectedColor);
    }

    public boolean isWhitePawn() {
        return isRightColor(Color.WHITE) && type == Type.PAWN;
    }

    public boolean isBlackPawn() {
        return isRightColor(Color.BLACK) && type == Type.PAWN;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Piece)) return false;
        Piece piece = (Piece) obj;
        return getColor() == piece.getColor() && getType() == piece.getType() && position.equals(piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getType(), position);
    }

    @Override
    public String toString() {
        return "Piece [color=" + color
                + ", type=" + type
                + ", position=" + position + ']';
    }

    @Override
    public int compareTo(Piece p) {
        return Double.compare(type.getDefaultPoint(), p.type.getDefaultPoint());
    }
}
