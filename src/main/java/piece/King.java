package piece;

import chess.Position;
import piece.attribute.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;


public class King extends Piece {

    King(Color color, Position position) {
        super(color, Type.KING, position);
    }

    @Override
    List<Direction> movableDirections() {
        return Direction.everyDirection();
    }




}

