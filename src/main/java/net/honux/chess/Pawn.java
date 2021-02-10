package net.honux.chess;

public class Pawn {
    public static final String white = "White";
    public static final String black = "Black";

    private String color;

    public Pawn() {
        this.color = Pawn.white;
    }

    public Pawn(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
