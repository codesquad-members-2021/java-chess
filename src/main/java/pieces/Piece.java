package pieces;

public class Piece {

    private Color color;

    private PieceRepresentation representation;

    public enum Color {
        WHITE, BLACK
    }

    public enum PieceRepresentation{
        P, p, N, n, R, r, B, b, Q, q, K, k
    }

    private Piece(Color color, PieceRepresentation pieceRepresentation) {
        this.color = color;
        this.representation = pieceRepresentation;
    }

    public Color getColor() {
        return color;
    }

    public PieceRepresentation getRepresentation(){
        return representation;
    }


    public static Piece createWhitePawn(){
        return new Piece(Color.WHITE, PieceRepresentation.p);
    }



}
