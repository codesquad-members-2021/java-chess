package pieces;

public class Pawn extends Piece {
    public static final char BLACK_REPRESENTATION = 'P';
    public static final char WHITE_REPRESENTATION = 'p';

    public Pawn() {
        super(Piece.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
    }

    public Pawn(String color) {
        super(color, Pawn.WHITE_REPRESENTATION);
    }

    public Pawn(String color, char representation) {
        super(color, representation);
    }

    public String getColor() {
        return super.getColor();
    }

    public char getRepresentation() {
        return super.getRepresentation();
    }
}
