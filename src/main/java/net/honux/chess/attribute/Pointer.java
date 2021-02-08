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
        String pointer1 = pointer.getPointer();
        this.x = pointer1.split(separator)[0].charAt(0);
        this.y = Integer.parseInt(pointer1.split(separator)[1]);
    }

    private void setX(char x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }

    public String getPointer(){
        return String.valueOf(this.x) + separator + this.y;
    }
}
