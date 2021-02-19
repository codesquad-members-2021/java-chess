package net.nas.pieces;

import java.util.function.Function;

public enum ColorOfChessPiece {
    WHITE(String::toLowerCase),
    BLACK(String::toUpperCase),
    BLANK((representationString) -> ".");
    private final Function<String, String> representationFunction;

    ColorOfChessPiece(Function<String, String> representationFunction) {
        this.representationFunction = representationFunction;
    }

    public String getRepresentationByColor(String representationString) {
        return representationFunction.apply(representationString);
    }
}
