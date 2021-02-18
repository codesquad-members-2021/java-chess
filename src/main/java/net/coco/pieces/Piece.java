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
                , Representation.WHITE_PAWN.getRepresentation());
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK
                , Representation.BLACK_PAWN.getRepresentation());
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE
                , Representation.WHITE_KNIGHT.getRepresentation());
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK
                , Representation.BLACK_KNIGHT.getRepresentation());
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE
                , Representation.WHITE_ROOK.getRepresentation());
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK
                , Representation.BLACK_ROOK.getRepresentation());
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE
                , Representation.WHITE_BISHOP.getRepresentation());
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK
                , Representation.BLACK_BISHOP.getRepresentation());
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE
                , Representation.WHITE_QUEEN.getRepresentation());
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK
                , Representation.BLACK_QUEEN.getRepresentation());
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE
                , Representation.WHITE_KING.getRepresentation());
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK
                , Representation.BLACK_KING.getRepresentation());
    }


    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
