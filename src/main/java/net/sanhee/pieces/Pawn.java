package net.sanhee.pieces;


public class Pawn {
    private final UnitColor color;

    public Pawn() {
        this.color = UnitColor.WHITE;
    }

    public Pawn(UnitColor color) {
        this.color = color;
    }

    public UnitColor getColor() {
        return color;
    }
}
