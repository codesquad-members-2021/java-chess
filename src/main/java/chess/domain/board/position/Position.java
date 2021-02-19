package chess.domain.board.position;

public class Position {
    private final char columnId;
    private final int rowId;

    Position(char columnId, int rowId) {
        this.columnId = columnId;
        this.rowId = rowId;
    }

    public static Position of(String positionId) {
        return PositionPool.getPosition(positionId);
    }

    public static Position of(char columnId, int rowId) {
        String positionId = getId(columnId, rowId);
        return of(positionId);
    }

    static String getId(char columnId, int rowId) {
        return String.valueOf(columnId) + rowId;
    }
}
