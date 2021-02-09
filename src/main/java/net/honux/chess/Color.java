package net.honux.chess;

public enum Color {
    white, black;

    public static Color getColor(String color) {
        switch (color) {
            case "white":
                return white;
            case "black":
                return black;
            default:
                throw new IllegalArgumentException("color should be white or black!");
        }

    }
}
