package pieces;

public class Piece {
    public final static String WHITE = "white";
    public final static String BLACK = "black";
    public final static String PAWN = "pawn";
    public final static String KNIGHT = "knight";
    public final static String ROOK = "rook";
    public final static String BISHOP = "bishop";
    public final static String QUEEN = "queen";
    public final static String KING = "king";
    public final static String WHITE_PAWN_REPRESENTATION = "p";
    public final static String BLACK_PAWN_REPRESENTATION = "P";
    private final String representation;
    private final String color;
    private final String name;

    private Piece(String name, String color, String representation) {
        this.color = color;
        this.representation = representation;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(PAWN, WHITE, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(PAWN, BLACK, BLACK_PAWN_REPRESENTATION);
    }
}
