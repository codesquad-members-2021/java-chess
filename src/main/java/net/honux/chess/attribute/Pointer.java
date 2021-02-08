package net.honux.chess.attribute;

public class Pointer {

    private char x;
    private int y;
    private final String separator = ",";

    public Pointer(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPointer(Pointer pointer){
        String pointer1 = pointer.toString();
        this.x = pointer1.split(separator)[0].charAt(0);
        this.y = Integer.parseInt(pointer1.split(separator)[1]);
    }

    public String toString(){
        return String.valueOf(this.x) + separator + this.y;
    }

    public char getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
