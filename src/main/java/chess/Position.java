package chess;

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
}
