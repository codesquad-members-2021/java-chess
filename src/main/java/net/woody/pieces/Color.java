package net.woody.pieces;

public enum Color {

    WHITE, BLACK;

    public static Color value(String color) {
        switch (color) {
            case "white":
                return WHITE;
            case "black":
                return BLACK;
            default:
                throw new IllegalArgumentException("color should be white or black!");
        }
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
