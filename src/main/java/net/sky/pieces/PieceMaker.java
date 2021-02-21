package net.sky.pieces;

public class PieceMaker {

    private Color color;

    public PieceMaker(Color color) {
        this.color = color;
    }

    public Piece createPawn() {
        return new Piece(color, PieceType.PAWN);
    }

    public Piece createKnight() {
        return new Piece(color, PieceType.KNIGHT);
    }

    public Piece createRook() {
        return new Piece(color, PieceType.ROOK);
    }

    public Piece createBishop() {
        return new Piece(color, PieceType.BISHOP);
    }

    public Piece createQueen() {
        return new Piece(color, PieceType.QUEEN);
    }

    public Piece createKing() {
        return new Piece(color, PieceType.KING);
    }


}
