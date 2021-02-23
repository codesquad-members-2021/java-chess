package net.coco.pieces;

import java.time.Period;

public class Piece {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String NO_COLOR = "noColor";

    private final String color;
    private final char representation;
    private final PieceType pieceType;
    private final double score;

    private Piece(String color, PieceType pieceType) {
        this.color = color;
        this.representation = pieceType.getRepresentation(color);
        this.score = pieceType.getScore();
        this.pieceType = pieceType;
    }

    private static Piece createWhite(PieceType pieceType) {
        return new Piece(WHITE, pieceType);
    }

    private static Piece createBlack(PieceType pieceType) {
        return new Piece(BLACK, pieceType);
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
        return new Piece(NO_COLOR, PieceType.NO_PIECE);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, PieceType.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, PieceType.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, PieceType.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, PieceType.KING);
    }

    public String getColor() {
        return color;
    }

    public double getScore() {
        return score;
    }

    public char getRepresentation() {
        return representation;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isBlack() {
        return color.equals(BLACK);
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }
}
