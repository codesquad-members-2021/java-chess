package chess.domain.board;

import java.util.Objects;

public class Position {
    private final char columnId;
    private final int rowId;

    public Position(char columnId, int rowId) {
        this.columnId = columnId;
        this.rowId = rowId;
    }

    public Position(String positionId) {
        columnId = positionId.charAt(0);
        rowId = Integer.parseInt(positionId.substring(1));
    }

    @Override
    public String toString() {
        return String.valueOf(columnId) + rowId;
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
        return columnId == position.columnId && rowId == position.rowId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnId, rowId);
    }
}
