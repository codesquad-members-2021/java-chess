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
    public boolean isMovable(Position after) {
        if ((this.getPosition().isLinear(after))
                && isInValidMoveRange(after) && after.isValid()) {
            return true;
        }
        throw new PositionNotMovableException(getErrorMessage(after));
    }

    @Override
    boolean isInValidMoveRange(Position after) {
        return true;
    }
}

