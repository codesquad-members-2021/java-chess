package piece;

import chess.Position;
import piece.attribute.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Blank extends Piece {
    public Blank(Color color, Position position) {
        super(color, Type.BLANK, position);
    }

    @Override
    List<Direction> movableDirections() {
        return Collections.singletonList(Direction.INVALID);
    }

    @Override
    boolean isInValidMoveRange(Position after) {
        throw new PositionNotMovableException("Is not a piece");
    }
}

