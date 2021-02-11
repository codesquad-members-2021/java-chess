package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;

public class Pawn{

    private final Color color;

    public Pawn(){
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
