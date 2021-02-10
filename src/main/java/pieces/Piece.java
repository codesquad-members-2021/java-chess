package pieces;

public enum Piece {

    WHITE("white", 'p'),
    BLACK("black", 'P');

    public final String color;
    public final char pawn;

    Piece(String color, char pawn) {
        this.color = color;
        this.pawn = pawn;
    }

}
