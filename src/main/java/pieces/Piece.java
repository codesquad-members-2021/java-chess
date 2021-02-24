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
    public final static char WHITE_PAWN_SYMBOL = 'p';
    public final static char WHITE_KNIGHT_SYMBOL = 'n';
    public final static char WHITE_ROOK_SYMBOL = 'r';
    public final static char WHITE_BISHOP_SYMBOL = 'b';
    public final static char WHITE_QUEEN_SYMBOL = 'q';
    public final static char WHITE_KING_SYMBOL = 'k';
    public final static char BLACK_PAWN_SYMBOL = 'P';
    public final static char BLACK_KNIGHT_SYMBOL = 'N';
    public final static char BLACK_ROOK_SYMBOL = 'R';
    public final static char BLACK_BISHOP_SYMBOL = 'B';
    public final static char BLACK_QUEEN_SYMBOL = 'Q';
    public final static char BLACK_KING_SYMBOL = 'K';
    private final String name;
    private final String color;
    private final char symbol;

    private Piece(String name, String color, char symbol) {
        this.name = name;
        this.color = color;
        this.symbol = symbol;
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

    public char getSymbol() {
        return symbol;
    }

    public static Piece createWhitePawn() {
        return new Piece(PAWN, WHITE, WHITE_PAWN_SYMBOL);
    }

    public static Piece createBlackPawn() {
        return new Piece(PAWN, BLACK, BLACK_PAWN_SYMBOL);
    }

    public static Piece createWhiteKnight() {
        return new Piece(KNIGHT, WHITE, WHITE_KNIGHT_SYMBOL);
    }

    public static Piece createBlackKnight() {
        return new Piece(KNIGHT, BLACK, BLACK_KNIGHT_SYMBOL);
    }

    public static Piece createWhiteRook() {
        return new Piece(ROOK, WHITE, WHITE_ROOK_SYMBOL);
    }

    public static Piece createBlackRook() {
        return new Piece(ROOK, BLACK, BLACK_ROOK_SYMBOL);
    }

    public static Piece createWhiteBishop() {
        return new Piece(BISHOP, WHITE, WHITE_BISHOP_SYMBOL);
    }

    public static Piece createBlackBishop() {
        return new Piece(BISHOP, BLACK, BLACK_BISHOP_SYMBOL);
    }

    public static Piece createWhiteQueen() {
        return new Piece(QUEEN, WHITE, WHITE_QUEEN_SYMBOL);
    }

    public static Piece createBlackQueen() {
        return new Piece(QUEEN, BLACK, BLACK_QUEEN_SYMBOL);
    }

    public static Piece createWhiteKing() {
        return new Piece(KING, WHITE, WHITE_KING_SYMBOL);
    }

    public static Piece createBlackKing() {
        return new Piece(KING, BLACK, BLACK_KING_SYMBOL);
    }
}
