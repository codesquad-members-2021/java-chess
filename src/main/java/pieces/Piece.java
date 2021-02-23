package pieces;

public class Piece {

    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';

    private String color;
    private char representation;

    public Piece() {
        this(Piece.WHITE);
        this.representation = Piece.WHITE_REPRESENTATION;
    }

    public Piece(final String color) {
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
