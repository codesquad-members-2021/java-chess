package chess.domain.pieces;

import java.util.function.Function;

public enum Color {
    WHITE(icon -> Character.toLowerCase(icon)),
    BLACK(icon -> Character.toUpperCase(icon)),
    NOCOLOR(icon -> icon);

    private final Function<Character, Character> representationStrategy;

    Color(Function<Character, Character> representationStrategy) {
        this.representationStrategy = representationStrategy;
    }

    public char generateRepresentation(char representation) {
        return representationStrategy.apply(representation);
    }
}
