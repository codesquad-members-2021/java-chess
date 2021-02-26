package chess;

import java.util.Objects;

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

    public boolean isValid() {
        return x() >= 1 && x() <= 8 && y() >= 1 && y() <= 8;
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

