package chess.pieces;

public class Piece {
    public static final String PAWN_NAME   = "pawn";
    public static final String KNIGHT_NAME = "knight";
    public static final String ROOK_NAME   = "rook";
    public static final String BISHOP_NAME = "bishop";
    public static final String QUEEN_NAME  = "queen";
    public static final String KING_NAME   = "king";

    public static final String PAWN_REPRESENTATION   = "p";
    public static final String KNIGHT_REPRESENTATION = "n";
    public static final String ROOK_REPRESENTATION   = "r";
    public static final String BISHOP_REPRESENTATION = "b";
    public static final String QUEEN_REPRESENTATION  = "q";
    public static final String KING_REPRESENTATION   = "k";

    private final String name;
    private final Color color;
    private final String representation;

    private Piece(String name, Color color, String representation) {
        this.name = name;
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Piece.PAWN_NAME, Color.WHITE, Piece.PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Piece.PAWN_NAME, Color.BLACK, Piece.PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Piece.KNIGHT_NAME, Color.WHITE, Piece.KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(Piece.KNIGHT_NAME, Color.BLACK, Piece.KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(Piece.ROOK_NAME, Color.WHITE, Piece.ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(Piece.ROOK_NAME, Color.BLACK, Piece.ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Piece.BISHOP_NAME, Color.WHITE, Piece.BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(Piece.BISHOP_NAME, Color.BLACK, Piece.BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Piece.QUEEN_NAME, Color.WHITE, Piece.QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(Piece.QUEEN_NAME, Color.BLACK, Piece.QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(Piece.KING_NAME, Color.WHITE, Piece.KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(Piece.KING_NAME, Color.BLACK, Piece.KING_REPRESENTATION);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public String getRepresentation() {
        if (color == Color.BLACK) {
            return representation.toUpperCase();
        }
        return representation;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

}
