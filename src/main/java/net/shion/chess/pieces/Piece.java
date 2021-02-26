package net.shion.chess.pieces;

import java.util.List;
import java.util.Objects;

import static net.shion.chess.pieces.Piece.Type.PAWN;

public class Piece implements Comparable<Piece> {
    private final Type type;
    private final Color color;
    private final Position position;

    private Piece(Type type, Color color, Position position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

    public static Piece createWhite(Type type, Position position) {
        return new Piece(type, Piece.Color.WHITE, position);
    }

    public static Piece createBlack(Type type, Position position) {
        return new Piece(type, Piece.Color.BLACK, position);
    }

    public static Piece createBlank(Position position) {
        return new Piece(Type.NO_PIECE, Piece.Color.NO_COLOR, position);
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public double getPoint(List<Piece> remainedPieces) {
        if (this.type != PAWN) { // PAWN이 아니면 기본 점수를 반환한다.
            return this.type.getDefaultPoint();
        }

        List<Position> fileNeighbors = this.position.getFileNeighbors();  // 현재 위치의 file 위, 아래 position 리스트를 반환한다.
        for (Position position : fileNeighbors) {                         // 리스트에 있는 position 2개(위, 아래)를 검사할 것이다.
            if (remainedPieces.contains(new Piece(this.type, this.color, position))) {  // 남아있는 pieces중에서 현재 piece와 type(Pawn), color가 일치하고,
                return this.type.getDefaultPoint() - 0.5;                               // 위치가 위 또는 아래면 (== position) 0.5점을 반환한다.
            }
        }
        return this.type.getDefaultPoint();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return type == piece.type
                && color == piece.color
                && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, position);
    }

    @Override
    public String toString() {
        return type.name();
    }

    @Override
    public int compareTo(Piece o) {
        if (this.type.getDefaultPoint() < o.type.getDefaultPoint()) {
            return 1;
        } else {
            return -1;
        }
    }

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

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }

        public char getRepresentationWith(Color color) {
            if (color == Color.BLACK) {
                return Character.toUpperCase(representation);
            }
            return representation;
        }
    }
}
