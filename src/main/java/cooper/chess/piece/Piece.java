package cooper.chess.piece;

import java.util.Objects;

public class Piece {
    private final Color color;
    private final Type type;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }

    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }

    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }

    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }

    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }

    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }

    public static Piece createBlank() {
        return new Piece(Color.NO_COLOR, Type.NO_PIECE);
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return type.getRepresentaion(this.color);
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece)) {
            return false;
        }
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}
