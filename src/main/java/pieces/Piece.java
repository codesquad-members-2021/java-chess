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

    public static Piece createBlackPawn(){
        return new Piece(Color.BLACK, PieceRepresentation.P);
    }

    public static Piece createWhiteKnight(){
        return new Piece(Color.WHITE, PieceRepresentation.n);
    }

    public static Piece createBlackKnight(){
        return new Piece(Color.BLACK, PieceRepresentation.N);
    }

    public static Piece createWhiteRook(){
        return new Piece(Color.WHITE, PieceRepresentation.r);
    }

    public static Piece createBlackRook(){
        return new Piece(Color.BLACK, PieceRepresentation.R);
    }

    public static Piece createWhiteBishop(){
        return new Piece(Color.WHITE, PieceRepresentation.b);
    }

    public static Piece createBlackBishop(){
        return new Piece(Color.BLACK, PieceRepresentation.B);
    }

    public static Piece createWhiteQueen(){
        return new Piece(Color.WHITE, PieceRepresentation.q);
    }

    public static Piece createBlackQueen(){
        return new Piece(Color.BLACK, PieceRepresentation.Q);
    }

    public static Piece createWhiteKing(){
        return new Piece(Color.WHITE, PieceRepresentation.k);
    }

    public static Piece createBlackKing(){
        return new Piece(Color.BLACK, PieceRepresentation.K);
    }

    public boolean isWhite(Piece piece){
        return piece.getColor().equals(Piece.Color.WHITE);
    }

    public boolean isBlack(Piece piece){
        return piece.getColor().equals(Piece.Color.BLACK);
    }
}
