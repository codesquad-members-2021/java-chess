package net.sanhee.pieces;

public class PieceFactory {
    public Piece create(UnitType unitType, UnitColor unitColor) {
        Piece piece = null;
        switch (unitType) {
            case KNIGHT: //m switch 문에서 열거형 타입 생략
                piece = new Knight(unitColor);
                break;
            case PAWN:
                piece = new Pawn(unitColor);
                break;
        }
        return piece;
    }
}
