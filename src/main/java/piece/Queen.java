package piece;

import chess.Position;
import piece.attribute.*;

import java.util.List;

public class Queen extends Piece {
    Queen(Color color, Position position) {
        super(color, Type.QUEEN, position);
    }

    @Override
    List<Direction> movableDirections() {
        return Direction.everyDirection();
    }

    @Override
    public boolean isMovable(Position after) {
        if ((this.getPosition().isLinear(after) || this.getPosition().isDiagonal(after))
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

