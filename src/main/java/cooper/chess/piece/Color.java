package cooper.chess.piece;

import java.util.Arrays;

public enum Color {
    WHITE("white"),
    BLACK("black");

    private String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }

    public static Color of(String colorName) {
        return Arrays.stream(values())
                .filter(color -> color.colorName.equals(colorName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 색상이 존재하지 않습니다."));
    }
}

