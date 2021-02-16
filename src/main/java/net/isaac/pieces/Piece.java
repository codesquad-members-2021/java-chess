package net.isaac.pieces;

public abstract class Piece {
    Color color;

    public Piece(Color color){
        this.color = color;
    }

    //Board 출력을 위한 문자 반환
    public abstract char getRepresentation();

    public Color getColor() {
        return color;
    }

    public enum Color {
        BLACK,
        WHITE
    }
}
