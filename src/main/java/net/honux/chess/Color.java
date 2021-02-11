package net.honux.chess;

public enum Color {
    WHITE, BLACK;

    public static Color getColor(String color) {
        switch (color) {
            case "white":
                return WHITE;
            case "black":
                return BLACK;
            default:
                throw new IllegalArgumentException("color should be white or black!");
        }

    }
}
