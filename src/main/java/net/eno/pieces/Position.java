package net.eno.pieces;

public class Position {

    private final char file;
    private final int rank;

    public Position(String position) {
        this.file = position.charAt(0);
        this.rank = Character.getNumericValue(position.charAt(1));
    }

    public int getFileIndex() {
        return this.file - 'a';
    }

    public int getRankIndex() {
        return 8 - this.rank;
    }

}
