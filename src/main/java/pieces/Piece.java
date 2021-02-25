package pieces;

public class Piece {
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public static final String PAWN = "pawn";
    public static final String KNIGHT = "knight";
    public static final String ROOK = "rook";
    public static final String BISHOP = "bishop";
    public static final String QUEEN = "queen";
    public static final String KING = "king";

    public static final char WHITE_PAWN_SYMBOL = 'p';
    public static final char WHITE_KNIGHT_SYMBOL = 'n';
    public static final char WHITE_ROOK_SYMBOL = 'r';
    public static final char WHITE_BISHOP_SYMBOL = 'b';
    public static final char WHITE_QUEEN_SYMBOL = 'q';
    public static final char WHITE_KING_SYMBOL = 'k';
    public static final char BLACK_PAWN_SYMBOL = 'P';
    public static final char BLACK_KNIGHT_SYMBOL = 'N';
    public static final char BLACK_ROOK_SYMBOL = 'R';
    public static final char BLACK_BISHOP_SYMBOL = 'B';
    public static final char BLACK_QUEEN_SYMBOL = 'Q';
    public static final char BLACK_KING_SYMBOL = 'K';

    private final String name;
    private final String color;
    private final char symbol;

    private Piece(String name, String color, char symbol) {
        this.name = name;
        this.color = color;
        this.symbol = symbol;
    }

    boolean isWhite() {
        return color.equals(Piece.WHITE);
    }

    boolean isBlack() {
        return color.equals(Piece.BLACK);
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

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public char getSymbol() {
        return symbol;
    }
}
