package pieces;

import chess.Color;

public class Pawn {
    private Color color;

    public Pawn(Color color) {
        this.color = color;
    }

    public Pawn(){
        this(Color.WHITE);
    }

    public Color getColor(){
        return color;
    }
}
