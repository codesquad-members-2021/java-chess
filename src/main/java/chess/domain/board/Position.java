package chess.domain.board;

import java.util.Objects;

public class Position {
    private final char columnId;
    private final int rowId;

    private Position(char columnId, int rowId) {
        this.columnId = columnId;
        this.rowId = rowId;
    }

    public static Position of(char columnId, int rowId) {
        return new Position(columnId, rowId);
    }

    public static Position of(String positionId) {
        positionId = positionId.toLowerCase();
        char columnId = positionId.charAt(0);
        int rowId = Integer.parseInt(positionId.substring(1));
        return new Position(columnId, rowId);
    }

    @Override
    public String toString() {
        return String.valueOf(this.columnId) + this.rowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return this.columnId == position.columnId && this.rowId == position.rowId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.columnId, this.rowId);
    }
}
