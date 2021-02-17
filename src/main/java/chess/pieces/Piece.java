package chess.pieces;

public class Piece {
    private final Color color;
    private final String name;

    private Piece(Color color, String name){
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }
}


