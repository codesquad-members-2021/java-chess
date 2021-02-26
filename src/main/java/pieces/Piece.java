package pieces;

import java.util.List;
import java.util.Objects;

public class Piece {

    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private final char representation;
        private final double defaultPoint;

        private Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }
    }

    private final Color color;
    private final Type type;
    private final Position position;

    public char getRepresentation() {
        return isWhite() ? this.type.getWhiteRepresentation()
                : this.type.getBlackRepresentation();
    }

    public boolean verifyPiece(Color color, Type type) {
        return matchColor(color) && matchType(type);
    }

    private boolean matchColor(Color color) {
        return this.color == color;
    }

    private boolean matchType(Type type) {
        return this.type == type;
    }

    public void addPiecesByColor(Color color, List<Piece> piecesByColor) {
        if (matchColor(color)) {
            piecesByColor.add(this);
        }
    }

    public double getPoint(List<Piece> pieces) {
        double point = this.type.getDefaultPoint();
        if (!matchType(Type.PAWN)) {
            return point;
        }

        List<Position> nextColumn = this.position.nextColumn();
        for (Position position : nextColumn) {
            if (pieces.contains(new Piece(this.color, this.type, position))) {
                return point - 0.5;
            }
        }

        return point;
    }

    public Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    private static Piece createWhite(Type type, Position position) {
        return new Piece(Color.WHITE, type, position);
    }

    private static Piece createBlack(Type type, Position position) {
        return new Piece(Color.BLACK, type, position);
    }

    public static Piece createBlank(Position position) {
        return new Piece(Color.NO_COLOR, Type.NO_PIECE, position);
    }

    public static Piece createWhitePawn(Position position) {
        return createWhite(Type.PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return createBlack(Type.PAWN, position);
    }

    public static Piece createWhiteKnight(Position position) {
        return createWhite(Type.KNIGHT, position);
    }

    public static Piece createBlackKnight(Position position) {
        return createBlack(Type.KNIGHT, position);
    }

    public static Piece createWhiteRook(Position position) {
        return createWhite(Type.ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return createBlack(Type.ROOK, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return createWhite(Type.BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return createBlack(Type.BISHOP, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return createWhite(Type.QUEEN, position);
    }

    public static Piece createBlackQueen(Position position) {
        return createBlack(Type.QUEEN, position);
    }

    public static Piece createWhiteKing(Position position) {
        return createWhite(Type.KING, position);
    }

    public static Piece createBlackKing(Position position) {
        return createBlack(Type.KING, position);
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
}
