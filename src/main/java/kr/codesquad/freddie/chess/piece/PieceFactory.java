package kr.codesquad.freddie.chess.piece;

public class PieceFactory {
    private Color color;

    public PieceFactory(Color color) {
        this.color = color;
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Kind.EMPTY);
    }

    public Piece createPawn() {
        return new Piece(color, Kind.PAWN);
    }

    public Piece createKnight() {
        return new Piece(color, Kind.KNIGHT);
    }

    public Piece createRook() {
        return new Piece(color, Kind.ROOK);
    }

    public Piece createBishop() {
        return new Piece(color, Kind.BISHOP);
    }

    public Piece createQueen() {
        return new Piece(color, Kind.QUEEN);
    }

    public Piece createKing() {
        return new Piece(color, Kind.KING);
    }
}
