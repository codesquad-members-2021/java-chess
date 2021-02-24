package net.sanhee.pieces;

public class PieceFactory {
    public static Piece createBishop(UnitColor unitColor) { //m 정적 팩토리 메서드
        return new Bishop(unitColor);
    }

    public static Piece createKing(UnitColor unitColor) {
        return new King(unitColor);
    }

    public static Piece createKnight(UnitColor unitColor) {
        return new Knight(unitColor);
    }

    public static Piece createNone(UnitColor unitColor) {
        return new None(unitColor);
    }

    public static Piece createPawn(UnitColor unitColor) {
        return new Pawn(unitColor);
    }

    public static Piece createQueen(UnitColor unitColor) {
        return new Queen(unitColor);
    }

    public static Piece createRook(UnitColor unitColor) {
        return new Rook(unitColor);
    }

}
