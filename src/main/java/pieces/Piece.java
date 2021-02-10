package pieces;

public enum Piece {

    WHITE("white", 'p'),
    BLACK("black", 'P');

    private final String color;
    private final char pawn;

    Piece(String color, char pawn) {
        this.color = color;
        this.pawn = pawn;
    }

    public String getColor() {
        return this.color;
    }

    public char getPawn() {
        return this.pawn;
    }

}
