package net.woody.chess;

import java.util.Objects;

public class Position {

    private static final String FILE = "File ";
    private static final String RANK = "Rank ";

    private static final int BOARD_LENGTH = 8;
    private static final int ASCII_LOWERCASE = 97;
    private static final int ASCII_CHARINT = 48;

    private int file;
    private int rank;

    public Position(String position) {
        this(position.charAt(0) - ASCII_LOWERCASE,
                position.charAt(1) - ASCII_CHARINT - 1);
    }

    public Position(int file, int rank) {
        this.file = validatePosition(file, FILE);
        this.rank = validatePosition(rank, RANK);
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    private int validatePosition(int pos, String target) {
        if (pos < 0 || BOARD_LENGTH <= pos) {
            throw new IndexOutOfBoundsException(target + pos + "is out of range!");
        }
        return pos;
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
