package chess;

public class Position {
    private int file;
    private int rank;

    public Position(String position) {
        String[] pos = position.split("");
        file = pos[0].charAt(0) - 'a';
        rank = Integer.valueOf(pos[1]) - 1;
    }

    public int file() {
        return file;
    }

    public int rank() {
        return rank;
    }
}

