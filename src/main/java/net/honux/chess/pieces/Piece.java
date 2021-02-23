package net.honux.chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

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


    private Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
    }


    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isWhite(){
        return this.color.equals(WHITE_COLOR);
    }

    public boolean isBlack(){
        return this.color.equals(BLACK_COLOR);
    }
}

