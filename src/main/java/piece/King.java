package piece;

import chess.Position;
import piece.attribute.*;

import java.util.List;

public class King extends Piece {

    King(Color color, Position position) {
        super(color, Type.KING, position);
    }

    @Override
    List<Direction> movableDirections() {
        return Direction.everyDirection();
    }

    @Override
    boolean isInValidMoveRange(Position after) {
        return ((after.x() - getPosition().x()) == direction(after).xMove())
                && ((after.y() - getPosition().y()) == direction(after).yMove());
    }

    @Override
    public boolean isMovable(Position after) {
        if (movableDirections().contains(direction(after))
                && isInValidMoveRange(after) && after.isValid()) {
            return true;
        }
        throw new PositionNotMovableException(getErrorMessage(after));
    }
}

