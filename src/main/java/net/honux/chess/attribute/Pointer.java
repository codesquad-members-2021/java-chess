package net.honux.chess.attribute;

public class Pointer {

    private char x;
    private int y;

    public Pointer(char x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String separator = ",";
        return this.x + separator + this.y;
    }

    public char getX() {
        return x;
    }

    public void setX(char x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
