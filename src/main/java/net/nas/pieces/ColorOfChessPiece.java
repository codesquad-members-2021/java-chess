package net.nas.pieces;

import java.security.InvalidParameterException;
import java.util.function.Function;

public enum ColorOfChessPiece {
    WHITE(String::toLowerCase),
    BLACK(String::toUpperCase),
    BLANK((representationString) -> ".");

    private final Function<String, String> representationFunction;

    ColorOfChessPiece(Function<String, String> representationFunction) {
        this.representationFunction = representationFunction;
    }

    public String getRepresentationByColor(NameOfChessPiece name) {
        return representationFunction.apply(name.getRepresentation());
    }

    public static ColorOfChessPiece getColorByRepresentation(char representationChar) {
        if (representationChar == NameOfChessPiece.NO_PIECE.getRepresentation().charAt(0)) {
            return ColorOfChessPiece.BLANK;
        } else if (Character.isUpperCase(representationChar)) {
            return ColorOfChessPiece.BLACK;
        } else if (Character.isLowerCase(representationChar)) {
            return ColorOfChessPiece.WHITE;
        } else {
            throw new InvalidParameterException("Invalid color detected! representationChar : " + representationChar);
        }

    }
}
