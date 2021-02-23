package chess;

import java.util.Objects;

public class Position {
    private final char file;
    private final int rank;

    public Position(char file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public char getFile() {
        return file;
    }

    public int getRank() {
        return rank;
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
