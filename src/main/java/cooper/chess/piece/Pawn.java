package cooper.chess.piece;

public class Pawn {
    private Color color;

    public Pawn(String color) {
        this.color = Color.of(color);
    }

    public Pawn() {
        this.color = Color.WHITE;
    }

    public Color getColor() {
        return color;
    }
}