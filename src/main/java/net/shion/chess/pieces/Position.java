package net.shion.chess.pieces;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Position {
    private int file;
    private int rank;

    public Position(String position) {
        file = position.charAt(0) - 'a';
        rank = Character.getNumericValue(position.charAt(1)) - 1;
    }

    public Position(int file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public int file() {
        return file;
    }

    public int rank() {
        return rank;
    }

    public List<Position> getFileNeighbors(){
        return Arrays.asList(new Position(file, rank - 1), new Position(file, rank + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return file == position.file && rank == position.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}

