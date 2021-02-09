package net.kjk402.chess.pieces;

public class Pawn {
    private String color;
    public static String white = "white";
    public static String black = "black";

    public Pawn(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
