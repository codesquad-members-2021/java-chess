package chess.pieces;

public enum Color {
    WHITE("white",'p'),
    BLACK("white",'P');

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
}