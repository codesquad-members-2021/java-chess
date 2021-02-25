package piece;

import chess.Position;
import piece.attribute.*;

import java.util.*;

public class Knight extends Piece {
    Knight(Color color, Position position) {
        super(color, Type.KNIGHT, position);
    }


    @Override
    List<Direction> movableDirections() {
        return Direction.knightDirection();
    }


}

