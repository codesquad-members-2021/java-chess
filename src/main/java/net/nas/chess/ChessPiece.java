package net.nas.chess;

public abstract class ChessPiece {
    private String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
