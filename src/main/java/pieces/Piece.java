package pieces;

public class Piece {

    //검정색 대문자, 흰색 소문자
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';
    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';

    private String color;
    private char representation;

    private Piece(final String color, final char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public static Piece createWhitePawnInstance() {
        return new Piece(WHITE, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawnInstance() {
        return new Piece(BLACK, BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnightInstance() {
        return new Piece(WHITE, WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnightInstance() {
        return new Piece(BLACK, BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteRookInstance() {
        return new Piece(WHITE, WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackRookInstance() {
        return new Piece(BLACK, BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishopInstance() {
        return new Piece(WHITE, WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishopInstance() {
        return new Piece(BLACK, BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueenInstance() {
        return new Piece(WHITE, WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueenInstance() {
        return new Piece(BLACK, BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKingInstance() {
        return new Piece(WHITE, WHITE_KING_REPRESENTATION);
    }

    public static Piece createBlackKingInstance() {
        return new Piece(BLACK, BLACK_KING_REPRESENTATION);
    }

    public boolean isWhite() {
        if (this.color.equals("white")) {
            return true;
        }
        return false;
    }

    public boolean isBlack() {
        if (this.color.equals("black")) {
            return true;
        }
        return false;
    }
}
