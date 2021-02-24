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
    public final static String WHITE_KNIGHT_REPRESENTATION = "n";
    public final static String BLACK_KNIGHT_REPRESENTATION = "N";
    public final static String WHITE_ROOK_REPRESENTATION = "r";
    public final static String BLACK_ROOK_REPRESENTATION = "R";
    public final static String WHITE_BISHOP_REPRESENTATION = "b";
    public final static String BLACK_BISHOP_REPRESENTATION = "B";
    public final static String WHITE_QUEEN_REPRESENTATION = "q";
    public final static String BLACK_QUEEN_REPRESENTATION = "Q";
    public final static String WHITE_KING_REPRESENTATION = "k";
    public final static String BLACK_KING_REPRESENTATION = "K";
    private final String name;
    private final String color;
    private final String representation;

    private Piece(String name, String color, String representation) {
        this.color = color;
        this.representation = representation;
        this.name = name;
    }

    boolean isWhite() {
        return color == Piece.WHITE;
    }

    boolean isBlack() {
        return color == Piece.BLACK;
    }

    public String getName() {
        return name;
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

    public static Piece createWhiteKnight() {
        return new Piece(KNIGHT, WHITE, WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(KNIGHT, BLACK, BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(ROOK, WHITE, WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(ROOK, BLACK, BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(BISHOP, WHITE, WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(BISHOP, BLACK, BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(QUEEN, WHITE, WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(QUEEN, BLACK, BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(KING, WHITE, WHITE_KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(KING, BLACK, BLACK_KING_REPRESENTATION);
    }
}
