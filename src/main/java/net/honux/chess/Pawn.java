package net.honux.chess;

public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    private String color;

    public Pawn() {
        this.color = WHITE;
    }
    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
