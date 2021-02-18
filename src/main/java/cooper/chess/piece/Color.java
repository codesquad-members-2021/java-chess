package cooper.chess.piece;

import java.util.Arrays;

public enum Color {
    WHITE("white", 'P'),
    BLACK("black", 'p');

    private final String colorName;
    private final char representation;

    Color(String colorName, char representation) {
        this.colorName = colorName;
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }

    public String getColorName() {
        return colorName;
    }

    public static Color of(String colorName) {
        return Arrays.stream(values())
                .filter(color -> color.colorName.equals(colorName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 색상이 존재하지 않습니다."));
    }
}

