package chess.pieces;

public class Pawn {
    public static final String BLACK_REPRESENTATION = "P";
    public static final String WHITE_REPRESENTATION = "p";

    private Color color;
    private String representation;

    public static Pawn newWhitePawn() {
        return new Pawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
    }

    public static Pawn newBlackPawn() {
        return new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    private Pawn(Color color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
