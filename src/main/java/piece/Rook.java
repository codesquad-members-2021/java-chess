package piece;

import chess.Position;
import piece.attribute.*;

import java.util.List;

public class Rook extends Piece {
    Rook(Color color, Position position) {
        super(color, Type.ROOK, position);
    }

    @Override
    List<Direction> movableDirections() {
        return Direction.linearDirection();
    }

    @Override
    boolean isInValidMoveRange(Position after) {
        return true;
    }
}

