package pieces;

public class Pawn {

    private final Color color;

    private final PawnRepresentation representation;

    public enum Color {
        WHITE, BLACK
    }

    public enum PawnRepresentation{
        P, p
    }

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = PawnRepresentation.p;
    }

    public Pawn(final Color color) {
        if(color == Color.BLACK){
            this.color = Color.BLACK;
            this.representation = PawnRepresentation.P;
        }else {
            this.color = Color.WHITE;
            this.representation = PawnRepresentation.p;
        }
    }

    public Color getColor() {
        return color;
    }

    public PawnRepresentation getRepresentation(){
        return representation;
    }


}
