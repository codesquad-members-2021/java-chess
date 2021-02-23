package pieces;

public class Piece {

    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'K';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'k';
    public static final char WHITE_ROOK_REPRESENTATION = 'R';
    public static final char BLACK_ROOK_REPRESENTATION = 'r';
    public static final char WHITE_BISHOP_REPRESENTATION = 'B';
    public static final char BLACK_BISHOP_REPRESENTATION = 'b';
    public static final char WHITE_QUEEN_REPRESENTATION = 'Q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'q';
    public static final char WHITE_KING_REPRESENTATION = 'K';
    public static final char BLACK_KING_REPRESENTATION = 'k';

    private String color;
    private char representation;

    private Piece(final String color, final char representation) {
        this.color = color;
        this.representation = representation;
    }

    public Piece getWhitePawnInstance(){
        return new Piece(WHITE, WHITE_PAWN_REPRESENTATION);
    }

    public Piece getBlackPawnInstance(){
        return new Piece(BLACK, BLACK_PAWN_REPRESENTATION);
    }

    public Piece getWhiteKnightInstance(){
        return new Piece(WHITE, WHITE_KNIGHT_REPRESENTATION);
    }

    public Piece getBlackKnightInstance(){
        return new Piece(BLACK, BLACK_KNIGHT_REPRESENTATION);
    }

    public Piece getWhiteRookInstance(){
        return new Piece(WHITE, WHITE_ROOK_REPRESENTATION);
    }

    public Piece getBlackRookInstance(){
        return new Piece(BLACK, BLACK_ROOK_REPRESENTATION);
    }

    public Piece getWhiteBishopInstance(){
        return new Piece(WHITE, WHITE_BISHOP_REPRESENTATION);
    }

    public Piece getBlackBishopInstance(){
        return new Piece(BLACK, BLACK_BISHOP_REPRESENTATION);
    }

    public Piece getWhiteQueenInstance(){
        return new Piece(WHITE, WHITE_QUEEN_REPRESENTATION);
    }

    public Piece getBlackQueenInstance(){
        return new Piece(BLACK, BLACK_QUEEN_REPRESENTATION);
    }

    public Piece getWhiteKingInstance(){
        return new Piece(WHITE, WHITE_KING_REPRESENTATION);
    }

    public Piece getBlackKingInstance(){
        return new Piece(BLACK, BLACK_KING_REPRESENTATION);
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }


}
