package net.isaac.pieces;

public abstract class Piece {
    PieceColor color;
    //Board 출력을 위한 문자 반환
    public abstract char getRepresentation();

    public PieceColor getColor() {
        return color;
    }
}
