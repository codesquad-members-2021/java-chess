package net.sanhee.pieces;

public class PieceFactory {

    //m  createWhite(), createBlack() 가독성을 위해 중복을 감안하고 분리하였습니다.

    public Piece createWhite(UnitType unitType) {
        Piece piece = null;
        final UnitColor WHITE = UnitColor.WHITE;
        switch (unitType) {
            case KNIGHT: //m switch 문에서 열거형 타입 생략
                piece = new Knight(UnitColor.WHITE);
                break;
            case PAWN:
                piece = new Pawn(UnitColor.WHITE);
                break;
        }
        return piece;
    }

    public Piece createBlack(UnitType unitType) {
        Piece piece = null;
        switch (unitType) {
            case KNIGHT: //m switch 문에서 열거형 타입 생략
                piece = new Knight(UnitColor.BLACK);
                break;
            case PAWN:
                piece = new Pawn(UnitColor.BLACK);
                break;
        }
        return piece;
    }
}
