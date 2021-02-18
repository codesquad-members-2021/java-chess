package pieces;

public class Pawn {

    private Color color;

    private PawnRepresentation representation;

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
            new Pawn();
        }
    }

    public Color getColor() {
        return color;
    }

    public PawnRepresentation getRepresentation(){
        return representation;
    }


}
