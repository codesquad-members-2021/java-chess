package piece;

import chess.Position;
import piece.attribute.*;

import java.util.List;

public class Blank extends Piece {
    public Blank(Color color, Position position) {
        super(color, Type.BLANK, position);
    }

    @Override
    List<Direction> movableDirections() {
        return null;
    }

    @Override
    boolean isInValidMoveRange(Position after) {
        return true;
    }
}

