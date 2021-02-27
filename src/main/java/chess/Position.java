package chess;

public class Position {
    private int x;
    private int y;

    public Position(String position){
        x = position.charAt(0) - 'a';
        y = position.charAt(1) - '0' - 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
