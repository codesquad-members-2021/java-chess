package net.tree.pieces;

public class Piece {

    private String name;
    private String color;
    private char representation;

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    private Piece(Pieces pieces) {
        this.name = pieces.name();
        this.color = pieces.getColor();
        this.representation = pieces.getRepresentation();
    }

    public static Piece createWhitePawn() {
        return new Piece(Pieces.WHITE_PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Pieces.BLACK_PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Pieces.WHITE_KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Pieces.BLACK_KNIGHT);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Pieces.WHITE_BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(Pieces.BLACK_BISHOP);
    }

    public static Piece createWhiteRook() {
        return new Piece(Pieces.WHITE_ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(Pieces.BLACK_ROOK);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Pieces.WHITE_QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Pieces.BLACK_QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Pieces.WHITE_KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Pieces.BLACK_KING);
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public String getName() {
        return name;
    }

    public boolean isBlack() {
       return color.equals(BLACK_COLOR);
    }

    public boolean isWhite() {
        return color.equals(WHITE_COLOR);
    }

}
