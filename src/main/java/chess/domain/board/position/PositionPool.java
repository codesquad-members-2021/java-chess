package chess.domain.board.position;

import java.util.HashMap;
import java.util.Map;

import static chess.domain.board.BoardConst.*;

// NOTE: PositionPool 은 position 패키지 바깥에서 쓰여서는 안된다.
class PositionPool {
    private static final Map<String, Position> pool = new HashMap<>();

    static {
        for (int rowId = ROW_START; rowId <= ROW_END; rowId++) {
            addRow(rowId);
        }
    }

    private static void addRow(int rowId) {
        for (char columnId = COLUMN_START; columnId <= COLUMN_END; columnId++) {
            String positionId = Position.getId(columnId, rowId);
            Position position = new Position(columnId, rowId);
            pool.put(positionId, position);
        }
    }

    static Position getPosition(String positionId) {
        positionId = positionId.toLowerCase();
        return pool.get(positionId);
    }
}
