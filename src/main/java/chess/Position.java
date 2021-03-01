package chess;

import java.util.Objects;

import static chess.Board.BOARD_SIZE;

public class Position {
    private final char file;
    private final int rank;

    public Position(char file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public Position(String position) {
        this.file = position.charAt(0);
        this.rank = Character.getNumericValue(position.charAt(1));
    }

    public char getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public int x() {
        return file - 'a' + 1;
    }

    public int y() {
        return rank;
    }

    public boolean isLinear(Position after) {
        boolean isHorizontal = Math.abs(after.x() - x()) > 0 && after.y() == y();
        boolean isVertical = after.x() == x() && Math.abs(after.y() - y()) > 0;
        return isHorizontal || isVertical;
    }

    public boolean isDiagonal(Position after) {
        int xMove = Math.abs(after.x() - x());
        int yMove = Math.abs(after.y() - y());
        return yMove > 0 && xMove == yMove;
    }

    public boolean isValid() {
        return x() >= 1 && x() <= BOARD_SIZE && y() >= 1 && y() <= BOARD_SIZE;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            return file == ((Position) obj).file && rank == ((Position) obj).rank;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}

