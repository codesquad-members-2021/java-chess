package net.kjk402.chess.pieces;

public class Pawn {
    private String color;
    public static final String WHITE = "white";
    public static final String BLACK = "black";

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
