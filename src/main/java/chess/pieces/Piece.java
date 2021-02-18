package chess.pieces;

public class Piece {
    private final Color color;
    private final Type type;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public String getColorName() {
        return color.getColorName();
    }

    public boolean isWhite() {
        return getColorName().equals("white");
    }

    public boolean isBlack() {
        return getColorName().equals("black");
    }

    public char getWhiteRepresentation() {
        return type.getWhiteRepresentation();
    }

    public char getBlackRepresentation() {
        return type.getBlackRepresentation();
    }

}
