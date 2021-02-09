package pieces;

public class Pawn {
    private final Color color;

    enum Color {
        WHITE, BLACK
    }

    public Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
