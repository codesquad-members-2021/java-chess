package net.woody.pieces;

import java.util.function.Function;

public enum Color {

    WHITE("white", piece -> Character.toLowerCase(piece)),
    BLACK("black", piece -> Character.toUpperCase(piece));

    private String colorName;
    private Function<Character, Character> represent;

    Color(String colorName, Function<Character, Character> represent) {
        this.colorName = colorName;
        this.represent = represent;
    }

    public static Color color(String color) {
        switch (color) {
            case "white":
                return WHITE;
            case "black":
                return BLACK;
            default:
                throw new IllegalArgumentException("color should be white or black!");
        }

    }

    public String colorName() {
        return colorName;
    }

    public Character representation(char pieceFirstLetter) {
        return represent.apply(pieceFirstLetter);
    }
}
