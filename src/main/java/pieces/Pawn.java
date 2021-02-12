package pieces;

public class Pawn {
    private final Color color;

    Pawn() {
        this.color = Color.WHITE;
    }

    Pawn(Color color) {
        this.color = color;
    }

    Color getColor() {
        return color;
    }
}
