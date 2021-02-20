package net.coco.pieces;

public class Piece {
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    private final String color;
    private final char representation;

    private Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE
                , Representation.PAWN.getWhiteRepresentation());
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK
                , Representation.PAWN.getBlackRepresentation());
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE
                , Representation.KNIGHT.getWhiteRepresentation());
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK
                , Representation.KNIGHT.getBlackRepresentation());
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE
                , Representation.ROOK.getWhiteRepresentation());
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK
                , Representation.ROOK.getBlackRepresentation());
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE
                , Representation.BISHOP.getWhiteRepresentation());
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK
                , Representation.BISHOP.getBlackRepresentation());
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE
                , Representation.QUEEN.getWhiteRepresentation());
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK
                , Representation.QUEEN.getBlackRepresentation());
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE
                , Representation.KING.getWhiteRepresentation());
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK
                , Representation.KING.getBlackRepresentation());
    }


    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isBlack() {
        return color.equals("black");
    }

    public boolean isWhite() {
        return color.equals("white");
    }
}
