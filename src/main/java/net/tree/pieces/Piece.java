package net.tree.pieces;

public class Piece {

    //Piece와 종속적인 관계로 내부에 작성
    enum enumPieces{
        WHITE_PAWN('p'), BLACK_PAWN('P'),
        WHITE_KNIGHT('n'), BLACK_KNIGHT('N'),
        WHITE_BISHOP('b'), BLACK_BISHOP('B'),
        WHITE_ROOK('r'), BLACK_ROOK('R'),
        WHITE_QUEEN('q'), BLACK_QUEEN('Q'),
        WHITE_KING('k'), BLACK_KING('K');
        private final char representation;
          enumPieces(char representation) {
            this.representation = representation;
        }
        public char getRepresentation() { return representation; }
    }

    private String name;
    private String color;
    private char representation;

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    public static Piece createWhitePawn() {
        Piece piece = new Piece();
        piece.name = enumPieces.WHITE_PAWN.name();
        piece.color = WHITE_COLOR;
        piece.representation = enumPieces.WHITE_PAWN.getRepresentation();
        return piece;
    }

    public static Piece createBlackPawn() {
        Piece piece = new Piece();
        piece.name = enumPieces.BLACK_PAWN.name();
        piece.color = BLACK_COLOR;
        piece.representation = enumPieces.BLACK_PAWN.getRepresentation();
        return piece;
    }

    public static Piece createWhiteKnight() {
        Piece piece = new Piece();
        piece.name = enumPieces.WHITE_KNIGHT.name();
        piece.color = WHITE_COLOR;
        piece.representation = enumPieces.WHITE_KNIGHT.getRepresentation();
        return piece;
    }

    public static Piece createBlackKnight() {
        Piece piece = new Piece();
        piece.name = enumPieces.BLACK_KNIGHT.name();
        piece.color = BLACK_COLOR;
        piece.representation = enumPieces.BLACK_KNIGHT.getRepresentation();
        return piece;
    }

    public static Piece createWhiteBishop() {
        Piece piece = new Piece();
        piece.name = enumPieces.WHITE_BISHOP.name();
        piece.color = WHITE_COLOR;
        piece.representation = enumPieces.WHITE_BISHOP.getRepresentation();
        return piece;
    }

    public static Piece createBlackBishop() {
        Piece piece = new Piece();
        piece.name = enumPieces.BLACK_BISHOP.name();
        piece.color = BLACK_COLOR;
        piece.representation = enumPieces.BLACK_BISHOP.getRepresentation();
        return piece;
    }

    public static Piece createWhiteRook() {
        Piece piece = new Piece();
        piece.name = enumPieces.WHITE_ROOK.name();
        piece.color = WHITE_COLOR;
        piece.representation = enumPieces.WHITE_ROOK.getRepresentation();
        return piece;
    }

    public static Piece createBlackRook() {
        Piece piece = new Piece();
        piece.name = enumPieces.BLACK_ROOK.name();
        piece.color = BLACK_COLOR;
        piece.representation = enumPieces.BLACK_ROOK.getRepresentation();
        return piece;
    }

    public static Piece createWhiteQueen() {
        Piece piece = new Piece();
        piece.name = enumPieces.WHITE_QUEEN.name();
        piece.color = WHITE_COLOR;
        piece.representation = enumPieces.WHITE_QUEEN.getRepresentation();
        return piece;
    }

    public static Piece createBlackQueen() {
        Piece piece = new Piece();
        piece.name = enumPieces.BLACK_QUEEN.name();
        piece.color = BLACK_COLOR;
        piece.representation = enumPieces.BLACK_QUEEN.getRepresentation();
        return piece;
    }

    public static Piece createWhiteKing() {
        Piece piece = new Piece();
        piece.name = enumPieces.WHITE_KING.name();
        piece.color = WHITE_COLOR;
        piece.representation = enumPieces.WHITE_KING.getRepresentation();
        return piece;
    }

    public static Piece createBlackKing() {
        Piece piece = new Piece();
        piece.name = enumPieces.BLACK_KING.name();
        piece.color = BLACK_COLOR;
        piece.representation = enumPieces.BLACK_KING.getRepresentation();
        return piece;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public String getName() {
        return name;
    }

    public boolean isBlack() {
       return color.equals(BLACK_COLOR);
    }

    public boolean isWhite() {
        return color.equals(WHITE_COLOR);
    }
}
