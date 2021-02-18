package net.coco.pieces;

public class Piece {
    public static final String WHITE="white";
    public static final String BLACK="black";

    private final String color;
    private final char representation;

    private Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn(){
        return new Piece(WHITE
                ,Representation.WHITE_PAWN.getRepresentation());
    }
    public static Piece createBlackPawn(){
        return new Piece(BLACK
                ,Representation.BLACK_PAWN.getRepresentation());
    }



    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
