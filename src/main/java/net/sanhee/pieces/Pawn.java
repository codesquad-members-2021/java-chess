package net.sanhee.pieces;


public class Pawn {
    public static final int MAX_SPAWN_NUMBER = 8;
    private final UnitColor color;
    private final String shape;

    public Pawn() {
        this(UnitColor.WHITE);
    }

    public Pawn(UnitColor color) {
        this.color = color;

        switch (color){
            case BLACK:
                this.shape = "P";
                break;
            case WHITE:
            default:
                this.shape = "p";
        }
    }

    public UnitColor getColor() {
        return color;
    }
}
