package net.tree.chess;

public class Pawn {
    String color;

    final String WHITE = "white";
    final String BLACK = "black";

    public Pawn() {
        this.color = "white";
    }


    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
