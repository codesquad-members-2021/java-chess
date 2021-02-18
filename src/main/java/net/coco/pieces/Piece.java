package net.coco.pieces;

public class Piece {
    private final Color color;
    private final char representation;

    private Piece(Color color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn(){
        return new Piece(Color.WHITE
                ,Representation.WHITE_PAWN.getRepresentation());
    }
    public static Piece createBlackPawn(){
        return new Piece(Color.BLACK
                ,Representation.BLACK_PAWN.getRepresentation());
    }



    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
