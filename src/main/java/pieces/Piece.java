package pieces;

public enum Piece {
    PAWN_WHITE("white", 'p'),
    PAWN_BLACK("black", 'P');

    public final String color;
    public final char representation;

    Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

}
