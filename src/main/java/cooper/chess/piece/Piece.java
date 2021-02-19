package cooper.chess.piece;

public class Piece {
    private final Color color;
    private final Type type;

    public Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return type.getRepresentaion();
    }
}
