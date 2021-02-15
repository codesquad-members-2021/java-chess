package kr.codesquad.freddie.chess.piece;

public class PieceFactory {
    private PieceFactory() {
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Kind.PAWN);
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Kind.PAWN);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Kind.KNIGHT);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Kind.KNIGHT);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Kind.ROOK);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Kind.ROOK);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Kind.BISHOP);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Kind.BISHOP);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Kind.QUEEN);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Kind.QUEEN);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Kind.KING);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Kind.KING);
    }
}
