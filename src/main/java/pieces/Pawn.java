package pieces;

public class Pawn {

    private final Color color;
    private final char representation;

    public Pawn() {
        this(Color.WHITE);
    }

    public Pawn(Color color) {
        this.color = color;
        switch (color) {
            case BLACK:
                this.representation = 'P';
                break;
            case WHITE:
                this.representation = 'p';
                break;
            default:
                this.representation = ' ';
        }
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

}
