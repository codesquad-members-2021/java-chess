package net.coco.pieces;

import java.util.Objects;

public class Piece {

    public enum Color {
        WHITE,
        BLACK,
        NO_COLOR
    }

    private final Color color;
    private final PieceType pieceType;
    private final double score;

    private Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.score = pieceType.getScore();
        this.pieceType = pieceType;
    }

    private static Piece createWhite(PieceType pieceType) {
        return new Piece(Color.WHITE, pieceType);
    }

    private static Piece createBlack(PieceType pieceType) {
        return new Piece(Color.BLACK, pieceType);
    }

    public static Piece createWhitePawn() {
        return createWhite(PieceType.PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(PieceType.PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(PieceType.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(PieceType.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(PieceType.ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(PieceType.ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(PieceType.BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(PieceType.BISHOP);
    }

    public static Piece createBlank() {
        return new Piece(Color.NO_COLOR, PieceType.NO_PIECE);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, PieceType.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, PieceType.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, PieceType.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, PieceType.KING);
    }

    public Color getColor() {
        return color;
    }

    public double getScore() {
        return score;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Double.compare(piece.score, score) == 0 && Objects.equals(color, piece.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, score);
    }
}
