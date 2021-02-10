package pieces;

public class Pawn {

    private final String color;
    private final char representation;

    public Pawn() {
        this.color = Piece.PAWN_WHITE.color;
        this.representation = Piece.PAWN_WHITE.representation;
    }

    public Pawn(String color, char representation) {
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
