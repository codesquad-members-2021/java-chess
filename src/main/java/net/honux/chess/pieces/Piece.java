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
}
