package chess.pieces;

public class Pawn {
    private Color color;
    private char representation;

    public Pawn() {
        this(Color.WHITE);
    }

    public Pawn(Color color) {
        this.color = color;
        this.representation = color.getRepresentation();
    }

    public Color getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }
}


