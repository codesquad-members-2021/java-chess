package net.sanhee.pieces;

public class PieceFactory {
    public static Piece create(UnitType unitType, UnitColor unitColor) { //m 정적 팩토리 메서드
        Piece piece = null;
        switch (unitType) {
            case KNIGHT: //m switch 문에서 열거형 타입 생략
                piece = new Knight(unitColor);
                break;
            case BISHOP:
                piece = new Bishop(unitColor);
                break;
            case QUEEN:
                piece = new Queen(unitColor);
                break;
            case KING:
                piece = new King(unitColor);
                break;
            case ROOK:
                piece = new Rook(unitColor);
                break;
            case PAWN:
                piece = new Pawn(unitColor);
                break;
            case NONE:
                piece = new None(unitColor);
                break;
        }
        return piece;
    }
}
