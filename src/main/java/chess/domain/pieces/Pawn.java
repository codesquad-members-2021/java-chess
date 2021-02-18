package chess.domain.pieces;

public class Pawn extends Piece {
    public Pawn() {
        super();
    }

    public Pawn(Color color) {
        super(color);
    }

    @Override
    String getIcon() {
        return "P";
    }
}
