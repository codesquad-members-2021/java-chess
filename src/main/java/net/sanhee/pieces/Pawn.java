package net.sanhee.pieces;


public class Pawn {
    public static final int MAX_SPAWN_NUMBER = 8;
    public static final char BLACK_REPRESENTATION = 'P';
    public static final char WHITE_REPRESENTATION = 'p';

    private final UnitColor color;
    private final char shape;

    public Pawn() {
        this(UnitColor.WHITE);
    }

    public Pawn(UnitColor color) {
        this.color = color;

        switch (color) {
            case BLACK:
                this.shape = BLACK_REPRESENTATION;
                break;
            case WHITE:
            default:
                this.shape = WHITE_REPRESENTATION;
        }
    }

    public UnitColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return this.shape;
    }
}
