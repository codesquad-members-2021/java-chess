package chess.pieces;

public class Piece {

    private String name;
    private Color color;

    public Piece() {
        this(Color.WHITE);
    }

    public Piece(Color color){
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}


