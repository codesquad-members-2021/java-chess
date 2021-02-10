package net.nas.chess;

public abstract class ChessPiece {
    String color;

    public ChessPiece(String color) {
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}
