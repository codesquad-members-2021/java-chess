package chess.domain.pieces;

import java.util.function.Function;

public enum Color {
    WHITE(icon -> icon.toLowerCase()),
    BLACK(icon -> icon.toUpperCase());

    private final Function<String, String> representationStrategy;

    Color(Function<String, String> representationStrategy) {
        this.representationStrategy = representationStrategy;
    }

    public String generateRepresentation(String representation) {
        return representationStrategy.apply(representation);
    }
}
