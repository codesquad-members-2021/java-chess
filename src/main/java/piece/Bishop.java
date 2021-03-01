package piece;

import chess.Position;
import piece.attribute.*;

import java.util.List;

public class Bishop extends Piece {
    Bishop(Color color, Position position) {
        super(color, Type.BISHOP, position);
    }

    @Override
    List<Direction> movableDirections() {
        return Direction.diagonalDirection();
    }

    @Override
    public boolean isMovable(Position after) {
        if ((this.getPosition().isDiagonal(after))
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

