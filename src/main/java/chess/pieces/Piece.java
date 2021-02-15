package chess.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK__REPRESENTATION = 'P';

    private String name;
    private String color;
    private char representation;

    public Piece() {
        this(WHITE_COLOR, WHITE_REPRESENTATION);
    }

    public Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }
}


