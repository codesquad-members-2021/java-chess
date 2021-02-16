package pieces;

public class Pawn {

    private final Color color;

    private Character representation;

    public enum Color {
        WHITE, BLACK
    }

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = 'p';
    }

    public Pawn(final Color color, final char representation) {
        if(color == Color.BLACK){
            this.color = Color.BLACK;
            this.representation = representation;
        }else {
            this.color = Color.WHITE;
            this.representation = 'p';
        }
    }

    public Color getColor() {
        return color;
    }

    public Character getRepresentation(){
        return representation;
    }


}
