package chess.pieces;

public class Pawn {
    private final Color color;

    public Pawn() {
        color = Color.WHITE;
    }

    public Pawn(String color) {
        this.color = Color.valueOf(color.toUpperCase());
    }

    public String getColor() {
        return color.name().toLowerCase();
    }
}
