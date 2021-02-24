package net.kjk402.chess.pieces;

public class Position {
    private final int file;
    private final int rank;

    public Position(int file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public Position(String position) {
        this.file = position.charAt(0) - 'a';
        this.rank = Character.getNumericValue(position.charAt(1)) - 1;
    }

}
