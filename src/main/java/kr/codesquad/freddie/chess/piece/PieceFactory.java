package kr.codesquad.freddie.chess.piece;

public class PieceFactory {
    private Color color;

    public PieceFactory(Color color) {
        this.color = color;
    }

    public static Piece createBlank() {
        return EmptyPiece.create();
    }

    public Piece createPawn() {
        return Pawn.create(color);
    }

    public Piece createKnight() {
        return Knight.create(color);
    }

    public Piece createRook() {
        return Rook.create(color);
    }

    public Piece createBishop() {
        return Bishop.create(color);
    }

    public Piece createQueen() {
        return Queen.create(color);
    }

    public Piece createKing() {
        return King.create(color);
    }
}
