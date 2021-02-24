package pieces;

public class Piece {

    private Color color;

    private char representation;

//    public enum Color {
//        WHITE, BLACK
//    }

//    public enum PieceRepresentation{
//        P, p, N, n, R, r, B, b, Q, q, K, k
//    }

    private Piece(Color color, char Representation) {
        this.color = color;
        this.representation = Representation;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation(){
        return representation;
    }

    public static Piece createWhitePawn(){
        return new Piece(Color.WHITE, Character.toLowerCase(Representation.PAWN.value()));
    }

    public static Piece createBlackPawn(){
        return new Piece(Color.BLACK, Representation.PAWN.value());
    }

    public static Piece createWhiteKnight(){
        return new Piece(Color.WHITE, Character.toLowerCase(Representation.KNIGHT.value()));
    }

    public static Piece createBlackKnight(){
        return new Piece(Color.BLACK, Representation.KNIGHT.value());
    }

    public static Piece createWhiteRook(){
        return new Piece(Color.WHITE, Character.toLowerCase(Representation.ROOK.value()));
    }

    public static Piece createBlackRook(){
        return new Piece(Color.BLACK, Representation.ROOK.value());
    }

    public static Piece createWhiteBishop(){
        return new Piece(Color.WHITE, Character.toLowerCase(Representation.BISHOP.value()));
    }

    public static Piece createBlackBishop(){
        return new Piece(Color.BLACK, Representation.BISHOP.value());
    }

    public static Piece createWhiteQueen(){
        return new Piece(Color.WHITE, Character.toLowerCase(Representation.QUEEN.value()));
    }

    public static Piece createBlackQueen(){
        return new Piece(Color.BLACK, Representation.QUEEN.value());
    }

    public static Piece createWhiteKing(){
        return new Piece(Color.WHITE, Character.toLowerCase(Representation.KING.value()));
    }

    public static Piece createBlackKing(){
        return new Piece(Color.BLACK, Representation.KING.value());
    }

    public boolean isWhite(Piece piece){
        return piece.getColor().equals(Color.WHITE);
    }

    public boolean isBlack(Piece piece){
        return piece.getColor().equals(Color.BLACK);
    }

}
