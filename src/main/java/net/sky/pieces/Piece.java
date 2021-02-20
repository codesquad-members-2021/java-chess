package net.sky.pieces;

public class Piece {

    private final Color color;
    private final PieceType pieceType;
    private final char REPRESENTATION;

    private Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        this.REPRESENTATION = classifyRepresentation();
    }

    public static Piece getPawnInstance(Color color) {
        return new Piece(color, PieceType.PAWN);
    }

    public static Piece getKnightInstance(Color color) {
        return new Piece(color, PieceType.KNIGHT);
    }

    public static Piece getRookInstance(Color color) {
        return new Piece(color, PieceType.ROOK);
    }

    public static Piece getBishopInstance(Color color) {
        return new Piece(color, PieceType.BISHOP);
    }

    public static Piece getQueenInstance(Color color) {
        return new Piece(color, PieceType.QUEEN);
    }

    public static Piece getKingInstance(Color color) {
        return new Piece(color, PieceType.KING);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return REPRESENTATION;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isWhite(Piece piece) {
        if (piece.getColor() == Color.WHITE) {
            return true;
        }
        return false;
    }

    public boolean isBlack(Piece piece) {
        if (piece.getColor() == Color.BLACK) {
            return true;
        }
        return false;
    }

    private char classifyRepresentation() {
        char initRepresentation = pieceType.getRepresentation();
        if (color == Color.BLACK) {
            return Character.toUpperCase(initRepresentation);
        }
        return initRepresentation;
    }

}
