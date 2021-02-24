package net.sky.pieces;

import java.util.Objects;

public class Position {

    private final int rank;
    private final char file;

    public Position(String position) {
        this.rank = Character.getNumericValue(position.charAt(1));
        this.file = position.charAt(0);
    }

    public Position(int rank, char file) {
        this.rank = rank;
        this.file = file;
    }

    public char getFile() {
        return file;
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
        return rank == position.rank && file == position.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, file);
    }
}
