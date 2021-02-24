package net.woody.pieces;

import java.util.function.Function;

public enum Color {

    WHITE(piece -> Character.toLowerCase(piece)),
    BLACK(piece -> Character.toUpperCase(piece)),
    NOCOLOR(piece -> piece);

    private Function<Character, Character> representation;

    Color(Function<Character, Character> representation) {
        this.representation = representation;
    }

    public Character getRepresentation(char pieceFirstLetter) {
        return representation.apply(pieceFirstLetter);
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
