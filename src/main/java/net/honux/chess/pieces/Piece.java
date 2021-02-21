package net.honux.chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    public enum White {
        PAWN('p'), KNIGHT('n'), ROOK('r'),
        BISHOP('b'), QUEEN('q'), KING('k');

        public char representation;
        White(char representation) {
            this.representation = representation;
        }
    }

    public enum Black {
        PAWN('P'), KNIGHT('N'), ROOK('R'),
        BISHOP('B'), QUEEN('Q'), KING('K');

        public char representation;
        Black(char representation) {
            this.representation = representation;
        }
    }

    private String color;
    private char representation;

    private Piece() {}

    public Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE_COLOR, White.PAWN.representation);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK_COLOR, Black.PAWN.representation);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE_COLOR, White.KNIGHT.representation);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK_COLOR, Black.KNIGHT.representation);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE_COLOR, White.ROOK.representation);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK_COLOR, Black.ROOK.representation);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE_COLOR, White.BISHOP.representation);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK_COLOR, Black.BISHOP.representation);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE_COLOR, White.QUEEN.representation);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK_COLOR, Black.QUEEN.representation);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE_COLOR, White.KING.representation);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK_COLOR, Black.KING.representation);
    }

    public boolean isWhite() {
        if (this.color == WHITE_COLOR)
            return true;
        else
            return false;
    }

    public boolean isBlack() {
        if (this.color == BLACK_COLOR)
            return true;
        else
            return false;
    }
}
