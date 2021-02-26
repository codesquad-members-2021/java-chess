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

    @Override
    public Direction direction(Position after) {

        if (south(after) && west(after)) {
            if (after.x() -this.getPosition().x()  == Direction.WWS.xMove()) return Direction.WWS;
            return Direction.WSS;
        }
        if (south(after) && east(after)) {
            if (after.x()- this.getPosition().x() == Direction.ESS.xMove()) return Direction.ESS;
            return Direction.ESS;
        }
        if (north(after) && east(after)) {
            if (after.x() - this.getPosition().x() == Direction.ENN.xMove()) return Direction.ENN;
            return Direction.EEN;
        }
        if (north(after) && west(after)) {
            if (after.x() - this.getPosition().x() == Direction.WNN.xMove()) return Direction.WNN;
            return Direction.WWN;
        }
        return Direction.SAME;
    }

}

