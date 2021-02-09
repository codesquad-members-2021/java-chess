package net.honux.chess;

public class Pawn {

    private String color;

    public Pawn() {
        this("white");
    }

    public Pawn(String color) {
        if (!color.matches("(white)|(black)")) {
            throw new IllegalArgumentException("Color should be 'white' or 'black'!");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
