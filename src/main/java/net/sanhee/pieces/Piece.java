package net.sanhee.pieces;


abstract public class Piece {

    private final UnitColor color;
    private final char representation;

    public Piece(UnitColor color) {
        this.color = color;
        this.representation = UnitType.getMark(this.color, this.getClass().getSimpleName());
    }

    public UnitColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isColor(UnitColor color) {
        return this.getColor().equals(color);
    }

}
