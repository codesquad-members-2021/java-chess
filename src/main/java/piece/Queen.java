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
    boolean isInValidMoveRange(Position after) {
        return true;
    }

}

