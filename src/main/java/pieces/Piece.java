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

    public Piece(final String color, final String name) {
        this.color = color;
        this.name = name;

        if(color.equals("white")){
            this.representation = 'p';
            return;
        }
        this.representation = 'P';
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    private Piece getPieceInstance(final String color, final String name){
        return new Piece(color, name);
    }
}
