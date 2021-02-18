package chess.pieces;

public class Piece {
    private final Color color;
    private final String pieceName;

    public Piece(String pieceName) {
        this.pieceName = pieceName;
        this.color = Color.WHITE;
    }

    public Piece(Color color, String pieceName) {
        this.color = color;
        this.pieceName = pieceName;
    }

    public String getColorName() {
        return color.getColorName();
    }

    public char getRepresentation() {
        return color.getRepresentation();
    }

}
