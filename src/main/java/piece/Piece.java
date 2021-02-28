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
        return isWhite() ? this.type.getWhiteRepresentation()
                : this.type.getBlackRepresentation();
    }

    public boolean verifyPiece(Color color, Type type) {
        return matchColor(color) && matchType(type);
    }

    public boolean matchColor(Color color) {
        return this.color == color;
    }

    private boolean matchType(Type type) {
        return this.type == type;
    }

    public double getPoint(List<Piece> pieces) {
        double point = this.type.getDefaultPoint();
        if (!matchType(Type.PAWN)) {
            return point;
        }

        List<Position> prevNextRows = this.position.getPrevNextRows();
        for (Position position : prevNextRows) {
            if (pieces.contains(new Piece(this.color, this.type, position))) {
                return point - 0.5;
            }
        }

        return point;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    public boolean isWhitePawn() {
        return isWhite() && type == Type.PAWN;
    }

    public boolean isBlackPawn() {
        return isBlack() && type == Type.PAWN;
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
