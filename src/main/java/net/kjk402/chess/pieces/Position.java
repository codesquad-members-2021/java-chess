package net.kjk402.chess.pieces;

public class Position {
    private final int file;
    private final int rank;

    public Position(int file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public Position(String position) {
        this.rank = position.charAt(0) - 'a';
        this.file = Character.getNumericValue(position.charAt(1))-1;
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    public static void main(String[] args) {
        Position pe = new Position("c8");
        System.out.println(pe.getFile());
        System.out.println(pe.getRank());
    }

}
