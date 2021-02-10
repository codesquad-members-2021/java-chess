package net.honux.chess;

public class Pawn {
    private final Color color;

    public Pawn(String color) {
        this.color = Color.valueOf(color);
    }

    public String getColor() {
        return color.name();
    }
}
