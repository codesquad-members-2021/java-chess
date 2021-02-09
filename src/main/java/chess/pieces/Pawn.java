package chess.pieces;

public class Pawn {
    private final Color color;

    public enum Color{
        WHITE,
        BLACK
    }

    Pawn(){
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }


    public Color getColor() {
        return color;
    }
}
