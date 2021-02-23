package chess.pieces;

import java.util.List;

public class Piece implements Comparable<Piece> {
    private final Color color;
    private final Type type;
    private Position position;

    private Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    public Color getColor() {
        return this.color;
    }

    public Type getType() {
        return this.type;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getPoint() {
        return this.getType().getDefaultPoint();
    }

    public double getPoint(List<Piece> pieces) {
        if (getType() != Type.PAWN) {
            return this.type.getDefaultPoint();
        }

        double halfPawnPoint = 0.5;
        List<Position> positions = this.position.getFileNeighborPosition();
        for (Position position : positions) {
            if (pieces.contains(new Piece(this.color, this.type, position))) {
                return this.type.getDefaultPoint() - halfPawnPoint;
            }
        }
        return this.type.getDefaultPoint();
    }

    @Override
    public String toString() {
        return String.valueOf(getRepresentation());
    }

    @Override
    public int compareTo(Piece o) {
        return Double.compare(getPoint(), o.getPoint()) * -1;
    }

    public boolean isWhite() {
        return getColor() == Color.WHITE;
    }

    public boolean isBlack() {
        return getColor() == Color.BLACK;
    }

    public char getRepresentation() {
        return color == Color.WHITE ? type.getWhiteRepresentation() : type.getBlackRepresentation();
    }

    public boolean matchColorAndType(Color color, Type type) {
        return getColor() == color && getType() == type;
    }

    public boolean matchColor(Color color) {
        return getColor() == color;
    }


    private static Piece createWhite(Type type, Position position) {
        return new Piece(Color.WHITE, type, position);
    }

    private static Piece createBlack(Type type, Position position) {
        return new Piece(Color.BLACK, type, position);
    }

    public static Piece createWhitePawn(Position position) {
        return createWhite(Type.PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return createBlack(Type.PAWN, position);
    }

    public static Piece createWhiteRook(Position position) {
        return createWhite(Type.ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return createBlack(Type.ROOK, position);
    }

    public static Piece createWhiteKnight(Position position) {
        return createWhite(Type.KNIGHT, position);
    }

    public static Piece createBlackKnight(Position position) {
        return createBlack(Type.KNIGHT, position);
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

    public static Piece createBlank(Position position) {
        return new Piece(Color.NO_COLOR, Type.BLANK, position);
    }
}
