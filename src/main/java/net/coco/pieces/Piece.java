package net.coco.pieces;

public class Piece {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String NO_COLOR="noColor";

    private final String color;
    private final char representation;
    private final PieceType pieceType;

    private Piece(String color, PieceType pieceType) {
        this.color = color;
        this.representation = pieceType.getRepresentation(color);
        this.pieceType = pieceType;
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE, PieceType.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, PieceType.PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, PieceType.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, PieceType.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, PieceType.ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, PieceType.ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, PieceType.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, PieceType.BISHOP);
    }
    public static Piece createBlank(){
        return new Piece(NO_COLOR,PieceType.NO_PIECE);
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

    public char getRepresentation() {
        return representation;
    }

    public boolean isBlack() {
        return color.equals(BLACK);
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }
}
