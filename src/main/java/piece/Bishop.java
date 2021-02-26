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
    boolean isInValidMoveRange(Position after) {
        return true;
    }
}

