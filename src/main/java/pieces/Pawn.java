package pieces;

public class Pawn {

    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';

    private String color;
    private char representation;

    public Pawn() {
        this(Pawn.WHITE);
        this.representation = Pawn.WHITE_REPRESENTATION;
    }

    public Pawn(final String color) {
        this.color = color;

        if(color.equals("white")){
            this.representation = 'p';
            return;
        }
        this.representation = 'P';
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
}
