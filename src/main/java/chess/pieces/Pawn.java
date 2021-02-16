package chess.pieces;

public class Pawn {
    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_REPRESENTATION = "P";
    public static final String WHITE_REPRESENTATION = "p";

    private String color;
    private String representation;

    public static Pawn newWhitePawn() {
        return new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
    }

    public static Pawn newBlackPawn() {
        return new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    private Pawn(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }
}
