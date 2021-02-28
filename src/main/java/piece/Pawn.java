package piece;

import chess.Position;
import piece.attribute.*;

import java.util.List;

public class Pawn extends Piece {
    Pawn(Color color, Position position) {
        super(color, Type.PAWN, position);
    }

    @Override
    List<Direction> movableDirections() {
        return isBlack() ? Direction.blackPawnDirection() : Direction.whitePawnDirection();
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

