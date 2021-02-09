package net.honux.chess;

class Pawn {
    private final Color color;

    Pawn(String color) {
        this.color = Color.valueOf(color);
    }

    String getColor() {
        return color.name();
    }
}
