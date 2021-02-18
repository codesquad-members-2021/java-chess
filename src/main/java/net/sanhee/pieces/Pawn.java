package net.sanhee.pieces;


public class Pawn {
    public static final int MAX_SPAWN_NUMBER = 8;
    public static final char BLACK_REPRESENTATION = 'P';
    public static final char WHITE_REPRESENTATION = 'p';

    private final UnitColor color;

    public Pawn() {
        this(UnitColor.WHITE);
    }

    public Pawn(UnitColor color) {
        this.color = color;
    }

    public UnitColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return this.getShape();
    }

    public boolean isColor(UnitColor color) {
        return this.getColor().equals(color);
    }

    public char getShape() {
        switch (this.color) {
            case BLACK:
                return BLACK_REPRESENTATION;
            case WHITE:
            default:
                return WHITE_REPRESENTATION;
        }
    }
}
