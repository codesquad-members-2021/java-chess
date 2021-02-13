package mj.chess;

public class Pawn {
    private final Color color;

    public Pawn(String color) {
        this.color = Color.valueOf(color.toUpperCase());
    }

    public String getColor() {
        return color.name();
    }
}
