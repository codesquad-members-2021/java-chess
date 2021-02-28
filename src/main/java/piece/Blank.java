package piece;

import chess.Position;
import piece.attribute.*;

import java.util.*;

public class Blank extends Piece {
    public Blank(Color color, Position position) {
        super(color, Type.BLANK, position);
    }

    @Override
    List<Direction> movableDirections() {
        return Collections.singletonList(Direction.INVALID);
    }

    @Override
    public boolean isMovable(Position after) {
        return false;
    }

    @Override
    boolean isInValidMoveRange(Position after) {
        throw new PositionNotMovableException("Is not a piece");
    }
}

