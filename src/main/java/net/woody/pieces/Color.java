package net.woody.pieces;

import java.util.function.Function;

public enum Color {

    WHITE(piece -> Character.toLowerCase(piece)),
    BLACK(piece -> Character.toUpperCase(piece));

    private Function<Character, Character> represent;

    Color(Function<Character, Character> represent) {
        this.represent = represent;
    }

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

    public Character representation(char pieceFirstLetter) {
        return represent.apply(pieceFirstLetter);
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
