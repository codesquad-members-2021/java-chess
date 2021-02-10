package pieces;

public class Pawn {

    private final String color;
    private final char representation;

    public Pawn() {
        this.color = Piece.WHITE.color;
        this.representation = Piece.WHITE.pawn;
    }

    public Pawn(Piece piece) {
        this.color = piece.color;
        this.representation = piece.pawn;
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }

}
