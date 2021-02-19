package chess.domain.board.position;

import chess.exception.BadPositionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
        return Optional.ofNullable(pool.get(positionId.toLowerCase()))
                .orElseThrow(() -> new BadPositionException(positionId + ": 잘못된 체스 위치 입니다."));
    }
}
