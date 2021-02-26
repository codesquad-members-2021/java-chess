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
}

