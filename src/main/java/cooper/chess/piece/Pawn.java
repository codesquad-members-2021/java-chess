package cooper.chess.piece;

public class Pawn {
    private Color color;

    public Pawn(String color) {
        this.color = Color.of(color);
    }

    public Color getColor() {
        return color;
    }
}