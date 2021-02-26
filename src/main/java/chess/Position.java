package chess;

public class Position {
    private char file;
    private char rank;

    public Position(String position){
        file = position.charAt(0);
        file = position.charAt(1);
    }

    public char getRank() {
        return rank;
    }


    public char getFile() {
        return file;
    }
}
