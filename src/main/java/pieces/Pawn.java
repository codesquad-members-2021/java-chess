package pieces;

public class Pawn {

    private final Color color;

    public enum Color {
        WHITE, BLACK
    }

    public Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = Color.BLACK;
    }

    public Color getColor() {
        return color;
    }


}
